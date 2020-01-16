package servlets;

import dao.SkillDao;
import dao.UserDao;
import model.Skill;
import model.User;
import org.hibernate.SessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

import static java.util.stream.Collectors.toMap;

@WebServlet(urlPatterns = "/user/skills")
public class UserSkillsServlet extends HttpServlet {
    private UserDao userDao;
    private SkillDao skillDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        List<Skill> skills= userDao.getAllSkills(user.getUsername());
        Map<Skill,Integer> mapOfSkills = new HashMap<>();
        Map<Skill,Integer> allSkillsPerUser = new HashMap<>();
        List<Skill> allAvailableSkills = skillDao.getAll();

        for(Skill s : skills){
            if (!mapOfSkills.containsKey(s)) {
                mapOfSkills.put(s, 1);
            }
            else {
                Integer counter = mapOfSkills.get(s);
                mapOfSkills.put(s, counter + 1);
            }
        }

        for(Skill s : allAvailableSkills){
            allSkillsPerUser.put(s,skillDao.numb(s.getName()));
        }

        Map<Skill,Integer> topFiveSkills = allSkillsPerUser.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).limit(5)
                .collect(toMap(e->e.getKey(),e->e.getValue(),(e1,e2)->e2, LinkedHashMap::new));

        req.setAttribute("topFive", topFiveSkills);
        req.setAttribute("skills",mapOfSkills);
        req.getRequestDispatcher("/WEB-INF/views/user-skills.jsp").forward(req,resp);
    }


    @Override
    public void init() throws ServletException {
        userDao = new UserDao((SessionFactory)getServletContext().getAttribute("session_factory"));
        skillDao= new SkillDao((SessionFactory)getServletContext().getAttribute("session_factory"));
    }
}
