package Servlets;

import ManagerInfo.ManagerDao;
import ManagerInfo.ManagerDaoFactory;
import Reimbursements.ReimRequest;
import Reimbursements.Requests;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResolvedRequests extends HttpServlet {
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
        out.println("<style>");
        out.println("body{\n" + "background-color: lightblue;\n" +"}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"container\">");
        out.println("<table class=\"table table-bordered\">");
        out.println("<thead class=\"thead-dark\">");
        out.println("<tr>");
        out.println("<th>Reimbursement ID</th>");
        out.println("<th>Employee ID</th>");
        out.println("<th>Amount</th>");
        out.println("<th>Subject</th>");
        out.println("<th>Status</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");

        List<Requests> reimRequestList = new ArrayList<>();

        ManagerDao dao = ManagerDaoFactory.getDao();
        try {
            reimRequestList = dao.viewResolvedRequests();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (Requests reimRequest : reimRequestList) {
            out.println("<tr>");
            out.println("<td>" + reimRequest.getReimid() + "</td>");
            out.println("<td>" + reimRequest.getEmpid()+ "</td>");
            out.println("<td>$" + reimRequest.getAmount()+ "</td>");
            out.println("<td>" + reimRequest.getSubject()+ "</td>");
            out.println("<td>" + reimRequest.getStatus()+ "</td>");
            out.println("</tr>");
        }
        out.close();

        out.println("</tbody>");
        out.println("</table>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");

    }
}