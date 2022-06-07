package Reimbursements;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import EmployeeInfo.*;

public class ReimRequest extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

//        int id = Integer.parseInt(request.getParameter("id")); //converts string to int
        double reqAmount = Double.parseDouble(request.getParameter("amount")); //converts string to double
        String subject = request.getParameter("subject");

        EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
        try {
            dao.requestReimbursement(reqAmount, subject, request, response);
        } catch (SQLIntegrityConstraintViolationException ee){
            ee.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        out.close();
    }
}
