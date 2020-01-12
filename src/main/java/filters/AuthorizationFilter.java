package filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebFilter(urlPatterns = "/*")
public class AuthorizationFilter extends HttpFilter {


    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        List<String> unprotectedPaths = Arrays.asList("/login","/register","/logout","/index.jsp");
        List<String> protectedPaths = Arrays.asList("/user/skills","/user/sources","/user/unknown-sources");
        String path= req.getServletPath();
        System.out.println("Sciezka: "+ path);
        if(unprotectedPaths.contains(path)){
            chain.doFilter(req,res);
        }else if(protectedPaths.contains(path)){
            if(req.getSession().getAttribute("user")==null){
                res.sendRedirect("/login");
            }else{
                chain.doFilter(req,res);
            }
        }else{
            res.sendError(500,"Nie ma takiej strony");
        }

    }
}
