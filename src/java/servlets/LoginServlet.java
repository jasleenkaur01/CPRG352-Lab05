package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.AccountService;

public class LoginServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        HttpSession session = request.getSession();
        User username = (User) session.getAttribute("username");
        String logout = request.getParameter("logout");
        
        if(logout != null){
            session.invalidate();
            String message = "You have successfully logged out.";
            request.setAttribute("message", message);
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        return;
        }
        else
        {
            if(username != null)
            {
                response.sendRedirect("home");
                return;
            }
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        String username = request.getParameter("enter_username");
        String password = request.getParameter("enter_password");
        
        User user = new User(username, password);
        HttpSession session = request.getSession();
        AccountService as = new AccountService();
        request.setAttribute("username", username);
        request.setAttribute("password", password);
        
        if(username == null || username.equals("") || password == null || password.equals("")){
          String message = "Login failed. Please enter a valid username or password.";
          request.setAttribute("message", message);
            
          getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        return; 
        }
        else{
            session.setAttribute("username", user);
            response.sendRedirect("home");
            return;
        } 
        
    }
}