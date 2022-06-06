package Servlets;

import EmployeeInfo.*;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class EmployeeLogin extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Employee employee = new Employee();
        employee.setUsername(username);
        employee.setPassword(password);

        Cookie cookie = new Cookie("username", username);
        response.addCookie(cookie);

        EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
        try {
           dao.login(employee, request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        out.close();
    }
}
