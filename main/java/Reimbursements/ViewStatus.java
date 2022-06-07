package Reimbursements;

import EmployeeInfo.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViewStatus extends HttpServlet {

        public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            List<Requests> requestsList = new ArrayList<>();

            EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();

            Cookie[] cookies = request.getCookies();
            String id = cookies[0].getValue(); //converts cookie into string
            int empid = Integer.parseInt(id); //converts string into int

            out.println("<!doctype html>");
            out.println("<html lang=\"en\">");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">");
            out.println("<meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">");
            out.println("<title>EmployeeInfo</title>");
            out.println("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css\" integrity=\"sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn\" crossorigin=\"anonymous\">");
            out.println("<style>\n" +
                    "        body{\n" +
                    "        background-color: lightblue;\n" +
                    "        }\n" +
                    "ul{\n" +
                    "            list-style: none;\n" +
                    "            background-color: darkblue;\n" +
                    "            padding: 10px;\n" +
                    "            width: 275px;\n" +
                    "            margin-top: 10px;\n" +
                    "            border-radius: 10px;\n" +
                    "            font-family: 'Oswald', sans-serif;\n" +
                    "        }\n" +
                    "\n" +
                    "        li{\n" +
                    "            display: inline-block;\n" +
                    "            overflow: hidden; \n" +
                    "        }\n" +
                    "\n" +
                    "        label{\n" +
                    "            text-decoration: none;\n" +
                    "            font-size: 20px;\n" +
                    "            color: white;\n" +
                    "            padding: 5px;\n" +
                    "        }\n" +
                    "\n" +
                    "        button{\n" +
                    "            text-decoration: none;\n" +
                    "            font-size: 15px;\n" +
                    "            color: black;\n" +
                    "            padding: 8px;\n" +
                    "        }\n" +
                    "\n" +
                    "        button:hover{\n" +
                    "            background-color: rgb(108, 178, 255);\n" +
                    "            transition: .5s;\n" +
                    "        }" +
                    "    </style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<ul>\n" +
                    "<form action=\"eprofile\" method=\"get\">\n" +
                    "    <li><label>Return to Profile</label></li>\n" +
                    "    <li><button type=\"submit\" name=\"Profile\">Profile</button></li>\n" +
                    "</form>\n" +
                    "</ul>");
            out.println("<div class=\"container\">");
            out.println("<table class=\"table table-bordered\">");
            out.println("<thead class=\"thead-dark\">");
            out.println("<tr>");
            out.println("<th>Reimbursement ID</th>");
            out.println("<th>Amount</th>");
            out.println("<th>Subject</th>");
            out.println("<th>Status</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");

            try {
                requestsList = dao.requests(empid, request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            for (Requests allRequests : requestsList) {
                out.println("<tr>");
                out.println("<td>" + allRequests.getReimid() + "</td>");
                out.println("<td>$" + allRequests.getAmount() + "</td>");
                out.println("<td>" + allRequests.getSubject() + "</td>");
                out.println("<td>" + allRequests.getStatus() + "</td>");
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
