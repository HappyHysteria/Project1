package Servlets;

import EmployeeInfo.Employee;
import ManagerInfo.ManagerDao;
import ManagerInfo.ManagerDaoFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViewEmployees extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        request.getRequestDispatcher("managerNav.html").include(request, response);

        out.println("<!doctype html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">");
        out.println("<meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">");
        out.println("<title>EmployeeList</title>");
        out.println("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css\" integrity=\"sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn\" crossorigin=\"anonymous\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"container\">");
        out.println("<table class=\"table table-bordered\">");
        out.println("<thead class=\"thead-dark\">");
        out.println("<tr>");
        out.println("<th>ID</th>");
        out.println("<th>Name</th>");
        out.println("<th>Username</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");

        List<Employee> employeeList = new ArrayList<>();

        ManagerDao dao = ManagerDaoFactory.getDao();
        try {
            employeeList = dao.viewAllEmployees();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (Employee employee : employeeList) {
            out.println("<tr>");
<<<<<<< HEAD
            out.println("<td>" + employee.getID() + "</td>");
=======
            out.println("<td>" + employee.getEmpid() + "</td>");
>>>>>>> 0bc4995f5066b4d703fcd3bace921ad4b6e2e1d7
            out.println("<td>" + employee.getName()+ "</td>");
            out.println("<td>" + employee.getUsername()+ "</td>");
            out.println("</tr>");
        }
        out.close();
        out.println("</tbody>");
        out.println("</table>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");

    }

<<<<<<< HEAD
}
=======
}
>>>>>>> 0bc4995f5066b4d703fcd3bace921ad4b6e2e1d7
