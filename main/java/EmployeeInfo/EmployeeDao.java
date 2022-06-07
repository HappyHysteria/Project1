package EmployeeInfo;

<<<<<<< HEAD
import java.sql.SQLException;

public interface EmployeeDao {
    void login (Employee employee) throws SQLException;
=======
import Reimbursements.ReimRequest;
import Reimbursements.Requests;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {
    void login (Employee employee, HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException;
    List<Employee> info(String user, HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException;
    void updateInfo(String user, String pass, HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException;
    void requestReimbursement(double reqAmount, String subject, HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException;
    List<Requests> requests(int empid, HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException;
>>>>>>> 0bc4995f5066b4d703fcd3bace921ad4b6e2e1d7
}
