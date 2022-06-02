package Servlets;

import EmployeeInfo.Employee;
import ManagerInfo.Manager;
import ManagerInfo.ManagerDao;
import ManagerInfo.ManagerDaoFactory;
import Reimbursements.ReimRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViewEmployeeRequests extends HttpServlet {
    public void goPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String empID = request.getParameter("empID");

        ManagerDao dao = ManagerDaoFactory.getDao();

        List<ReimRequest> reimRequestList = new ArrayList<>();

        reimRequestList = dao.viewEmployeeRequests(empID);

        request.getRequestDispatcher("managerNav.html").include(request, response);

        
    }
}
