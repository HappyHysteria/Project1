package Servlets;

import EmployeeInfo.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeInfo extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();
        String username = cookies[1].getValue();

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
                "<form action='employeeupdateinfo.html' method='post'>\n" +
                        "  <li><label>Change Password</label></li>\n" +
                        "  <li><button type='submit' name='Profile'>Update</button></li>\n" +
                        "        </form>" +
                "</ul>");
        out.println("<div class=\"container\">");
        out.println("<table class=\"table table-bordered\">");
        out.println("<thead class=\"thead-dark\">");
        out.println("<tr>");
        out.println("<th>Employee ID</th>");
        out.println("<th>Name</th>");
        out.println("<th>Username</th>");
        out.println("<th>Password</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");

        List<Employee> employeeinfo = new ArrayList<>();

        EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
        try {
           employeeinfo = dao.info(username, request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for(Employee employee : employeeinfo){
            out.println("<tr>");
            out.println("<td>"+ employee.getEmpid() +"</td>");
            out.println("<td>"+ employee.getName() +"</td>");
            out.println("<td>"+ employee.getUsername() +"</td>");
            out.println("<td>"+ employee.getPassword() +"</td>");
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
