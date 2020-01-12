package servlets;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@WebServlet(urlPatterns = "/user/skills")
public class UserSkillsServlet extends HttpServlet {
    private UserDao userDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        List<Skill> skills= userDao.getAllSkills(user.getUsername());
        Map<Skill,Integer> mapOfSkills = new HashMap<>();

        for(Skill s : skills){
            if (!mapOfSkills.containsKey(s)) {
                mapOfSkills.put(s, 1);
            }
            else {
                Integer counter = mapOfSkills.get(s);
                mapOfSkills.put(s, counter + 1);
            }
        }
        req.setAttribute("skills",mapOfSkills);
        req.getRequestDispatcher("/WEB-INF/views/user-skills.jsp").forward(req,resp);
    }


    @Override
    public void init() throws ServletException {
        userDao = new UserDao((SessionFactory)getServletContext().getAttribute("session_factory"));
    }
}
