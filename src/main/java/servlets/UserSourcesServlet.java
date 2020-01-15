package servlets;

import dao.SourceDao;
import dao.UserDao;
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
import java.util.Set;

@WebServlet(urlPatterns = "/user/sources")
public class UserSourcesServlet extends HttpServlet {
    private UserDao userDao;
    private SourceDao sourceDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        List<Source> sources = userDao.getWithSources(user.getUsername());
        Map<Source,String> allKnownSources = new HashMap<>();
        for(Source s : sources){
            allKnownSources.put(s,sourceDao.showMeMySkills(s.getName()));
        }
        req.setAttribute("sources",allKnownSources);
        req.getRequestDispatcher("/WEB-INF/views/user-sources.jsp").forward(req,resp);

    }

    @Override
    public void init() throws ServletException {
        userDao = new UserDao((SessionFactory)getServletContext().getAttribute("session_factory"));
        sourceDao= new SourceDao((SessionFactory)getServletContext().getAttribute("session_factory"));
    }

}
