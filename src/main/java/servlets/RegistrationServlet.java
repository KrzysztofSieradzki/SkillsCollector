package servlets;

import dao.UserDao;
import model.User;
import org.hibernate.SessionFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/register")
public class RegistrationServlet extends HttpServlet {

    private UserDao userDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        User user = new User();
        user.setFirst_name(firstname);
        user.setLast_name(lastname);
        user.setPassword(password);
        user.setUsername(userName);
        if(!userDao.isUsernameAvailable(userName)){
            String errorMsg= "Username not available";
            req.setAttribute("error",errorMsg);
            req.setAttribute("user",user);
            req.getRequestDispatcher("WEB-INF/views/register.jsp").forward(req,resp);
        }else{

            userDao.save(user);
            resp.sendRedirect("/login");
        }
    }


    @Override
    public void init() throws ServletException {
       userDao= new UserDao((SessionFactory) getServletContext().getAttribute("session_factory"));

    }
}
