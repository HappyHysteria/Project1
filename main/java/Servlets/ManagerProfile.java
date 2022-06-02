package Servlets;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class ManagerProfile extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        request.getRequestDispatcher("nav.html").include(request, response);
        request.getRequestDispatcher("managerReimbursement.html").include(request, response);

        Cookie[] cookies = request.getCookies();
        String username = cookies[0].getValue();

        HttpSession session = request.getSession();
        session.setAttribute("username", username);

        out.close();
    }
}
