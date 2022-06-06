package ManagerInfo;

import EmployeeInfo.Employee;
import Reimbursements.ReimRequest;
import Reimbursements.Requests;

import java.sql.SQLException;
import java.util.List;

public interface ManagerDao {
    boolean managerLogin(Manager manager) throws SQLException;

    List<Employee> viewAllEmployees() throws SQLException;

    List<Requests> viewPendingRequests() throws SQLException;

    List<Requests> viewResolvedRequests() throws SQLException;

    List<Requests> viewEmployeeRequests(String empId) throws SQLException;

    boolean approveRequest(String reimID) throws SQLException;

    boolean denyRequest(String reimID) throws SQLException;
}
