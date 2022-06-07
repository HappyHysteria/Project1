package ManagerInfo;

import EmployeeInfo.Employee;
import Reimbursements.ReimRequest;
<<<<<<< HEAD
=======
import Reimbursements.Requests;
>>>>>>> 0bc4995f5066b4d703fcd3bace921ad4b6e2e1d7

import java.sql.SQLException;
import java.util.List;

public interface ManagerDao {
    boolean managerLogin(Manager manager) throws SQLException;

    List<Employee> viewAllEmployees() throws SQLException;

<<<<<<< HEAD
    List<ReimRequest> viewPendingRequests() throws SQLException;

    List<ReimRequest> viewResolvedRequests() throws SQLException;

    List<ReimRequest> viewEmployeeRequests(String empId) throws SQLException;
=======
    List<Requests> viewPendingRequests() throws SQLException;

    List<Requests> viewResolvedRequests() throws SQLException;

    List<Requests> viewEmployeeRequests(String empId) throws SQLException;
>>>>>>> 0bc4995f5066b4d703fcd3bace921ad4b6e2e1d7

    boolean approveRequest(String reimID) throws SQLException;

    boolean denyRequest(String reimID) throws SQLException;
<<<<<<< HEAD


=======
>>>>>>> 0bc4995f5066b4d703fcd3bace921ad4b6e2e1d7
}
