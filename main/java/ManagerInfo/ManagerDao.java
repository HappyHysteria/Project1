package ManagerInfo;

import EmployeeInfo.Employee;
import Reimbursements.ReimRequest;

import java.sql.SQLException;
import java.util.List;

public interface ManagerDao {
    boolean managerLogin(Manager manager) throws SQLException;

    List<Employee> viewAllEmployees() throws SQLException;

    List<ReimRequest> viewPendingRequests() throws SQLException;

    List<ReimRequest> viewResolvedRequests() throws SQLException;

    List<ReimRequest> viewEmployeeRequests(String empId) throws SQLException;

    boolean approveRequest(String reimID) throws SQLException;

    boolean denyRequest(String reimID) throws SQLException;


}
