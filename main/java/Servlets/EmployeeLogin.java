package Servlets;

<<<<<<< HEAD
import EmployeeInfo.Employee;

=======
import EmployeeInfo.*;
>>>>>>> 0bc4995f5066b4d703fcd3bace921ad4b6e2e1d7
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
<<<<<<< HEAD
=======
import java.sql.SQLException;
>>>>>>> 0bc4995f5066b4d703fcd3bace921ad4b6e2e1d7

public class EmployeeLogin extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

<<<<<<< HEAD
        request.getRequestDispatcher("nav.html").include(request, response);

        String username = request.getParameter("username");

        Employee employee = new Employee();
        employee.setUsername(username);
        employee.setPassword(request.getParameter("password"));
=======
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Employee employee = new Employee();
        employee.setUsername(username);
        employee.setPassword(password);
>>>>>>> 0bc4995f5066b4d703fcd3bace921ad4b6e2e1d7

        Cookie cookie = new Cookie("username", username);
        response.addCookie(cookie);

<<<<<<< HEAD
//        out.println("<h1><a href='profile'>Click Here</a></h1>");
=======
        EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
        try {
           dao.login(employee, request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
>>>>>>> 0bc4995f5066b4d703fcd3bace921ad4b6e2e1d7

        out.close();
    }
}
