package Servlets;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class ManagerProfile extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();




        Cookie[] cookies = request.getCookies();
        if (cookies != null){
            String username = cookies[0].getValue();
            if (!username.equals("")){
                out.println("<h1>Welcome to the Manager Homepage</h1>");
                request.getRequestDispatcher("managerNav.html").include(request, response);
            }else {
                out.println("please login first");
                request.getRequestDispatcher("/index.html").include(request, response);
            }
        }



        out.close();
    }
}
