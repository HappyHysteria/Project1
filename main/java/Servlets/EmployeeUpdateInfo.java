package Servlets;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import EmployeeInfo.*;

public class EmployeeUpdateInfo extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();
        String username = cookies[0].getValue();
        String password = request.getParameter("password");

        EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
        try {
            dao.updateInfo(username, password, request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
        out.close();
    }
}
