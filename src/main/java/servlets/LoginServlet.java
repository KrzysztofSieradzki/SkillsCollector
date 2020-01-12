package servlets;

import dao.UserDao;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UserDao userDao;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName=req.getParameter("username");
        String password=req.getParameter("password");
        if(userDao.getAllByUsernameAndPassword(userName,password).size()>0){
            User user = new User();
            user.setUsername(userName);
            user.setPassword(password);
            req.getSession().invalidate();
            req.getSession(true);
            req.getSession().setAttribute("user",user);
            resp.sendRedirect("/user/skills");
        }else{
            String error="Username or password incorrect";
            req.setAttribute("error",error);
            req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req,resp);
        }

    }

    @Override
    public void init() throws ServletException {
        userDao= new UserDao((SessionFactory) getServletContext().getAttribute("session_factory"));
    }
}
