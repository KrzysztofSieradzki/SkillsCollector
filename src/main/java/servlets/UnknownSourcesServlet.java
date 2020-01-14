package servlets;

import dao.SkillDao;
import dao.SourceDao;
import dao.UserDao;
import model.Skill;
import model.Source;
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

@WebServlet(urlPatterns = "/user/unknown-sources")
public class UnknownSourcesServlet extends HttpServlet {
    private UserDao userDao;
    private SourceDao sourceDao;
    private SkillDao skillDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        List<Source> unknownSources = sourceDao.getAll();
        List<Source> knownSources = userDao.getWithSources(user.getUsername());
        unknownSources.removeAll(knownSources);


        Map<Source ,String> sourcesWithSkills = new HashMap<>();
        for(Source s : unknownSources){
          // String output= skillDao.getAllBySource(s.getId()).toArray().toString();
          sourcesWithSkills.put(s,"dupa");
        }

        req.setAttribute("sources",sourcesWithSkills);
        req.getRequestDispatcher("/WEB-INF/views/user-unknown-sources.jsp").forward(req,resp);
    }

    @Override
    public void init() throws ServletException {
        userDao = new UserDao((SessionFactory)getServletContext().getAttribute("session_factory"));
        sourceDao= new SourceDao((SessionFactory)getServletContext().getAttribute("session_factory"));
        skillDao = new SkillDao((SessionFactory)getServletContext().getAttribute("session_factory"));
    }
}
