package Servlets;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class EmployeeProfile extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

<<<<<<< HEAD
        request.getRequestDispatcher("nav.html").include(request, response);
        request.getRequestDispatcher("employeeprofile.html").include(request, response);

        Cookie[] cookies = request.getCookies();
        String username = cookies[0].getValue();

        HttpSession session = request.getSession();
        session.setAttribute("username", username);

=======
        request.getRequestDispatcher("employeeprofile.html").include(request, response);

>>>>>>> 0bc4995f5066b4d703fcd3bace921ad4b6e2e1d7
        out.close();
    }
}
