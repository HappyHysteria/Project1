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

<<<<<<< HEAD
        request.getRequestDispatcher("nav.html").include(request, response);

=======
>>>>>>> 0bc4995f5066b4d703fcd3bace921ad4b6e2e1d7
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
            out.println("<br>");

<<<<<<< HEAD
=======
            request.getRequestDispatcher("managerNav.html").include(request, response);

>>>>>>> 0bc4995f5066b4d703fcd3bace921ad4b6e2e1d7
            Cookie cookie = new Cookie("username", username);
            response.addCookie(cookie);
        } else {
            out.println("sorry invalid login");
<<<<<<< HEAD
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.html");
=======
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("managerlogin.html");
>>>>>>> 0bc4995f5066b4d703fcd3bace921ad4b6e2e1d7
            requestDispatcher.include(request, response);
        }
        out.close();
    }
}