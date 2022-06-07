package Reimbursements;

<<<<<<< HEAD
public class ReimRequest {
    private int reimID;
    private int empID;
    private double amount;
    private String subject;
    private String status;

    public ReimRequest() {
    }

    public ReimRequest(int reimID, int empID, double amount, String subject, String status) {
        this.reimID = reimID;
        this.empID = empID;
        this.amount = amount;
        this.subject = subject;
        this.status = status;
    }

    public int getReimID() {
        return reimID;
    }

    public void setReimID(int reimID) {
        this.reimID = reimID;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Request{" +
                "reimID=" + reimID +
                ", empID=" + empID +
                ", amount=" + amount +
                ", subject='" + subject + '\'' +
                ", status='" + status + '\'' +
                '}';
=======
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
>>>>>>> 0bc4995f5066b4d703fcd3bace921ad4b6e2e1d7
    }
}
