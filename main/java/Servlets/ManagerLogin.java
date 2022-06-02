package Servlets;

import EmployeeInfo.Employee;
import ManagerInfo.Manager;
import ManagerInfo.ManagerDao;
import ManagerInfo.ManagerDaoFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class ManagerLogin extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Manager manager = new Manager();
        manager.setUsername(username);
        manager.setPassword(password);

        ManagerDao dao = ManagerDaoFactory.getDao();
        boolean result = false;

        try {
            result = dao.managerLogin(manager);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (result){
            out.println("you have login in");
            out.println("<br>Welcome " + username);
        } else {
            out.println("sorry invalid login");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.html");
            requestDispatcher.include(request, response);
        }
        out.close();
    }
}