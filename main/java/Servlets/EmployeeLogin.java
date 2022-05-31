package Servlets;

import EmployeeInfo.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class EmployeeLogin extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        request.getRequestDispatcher("nav.html").include(request, response);

        String username = request.getParameter("username");

        Employee employee = new Employee();
        employee.setUsername(username);
        employee.setPassword(request.getParameter("password"));

        Cookie cookie = new Cookie("username", username);
        response.addCookie(cookie);

//        out.println("<h1><a href='profile'>Click Here</a></h1>");

        out.close();
    }
}
