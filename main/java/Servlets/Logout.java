package Servlets;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Logout extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

<<<<<<< HEAD
        request.getRequestDispatcher("nav.html").include(request, response);
=======
        request.getRequestDispatcher("index.html").include(request, response);
>>>>>>> 0bc4995f5066b4d703fcd3bace921ad4b6e2e1d7

        Cookie cookie = new Cookie("username", "");
        response.addCookie(cookie);

        out.println("You have logged out");
    }
}
