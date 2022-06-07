package ManagerInfo;

import ConnectionInfo.ConnectionFactory;

import EmployeeInfo.Employee;
import Reimbursements.ReimRequest;
import Reimbursements.Requests;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManagerDaoImplement implements ManagerDao {
    Connection connection;

    public ManagerDaoImplement(){
        this.connection = ConnectionFactory.getConnection();
    }

    @Override
    public boolean managerLogin(Manager manager) throws SQLException {
        String sql = "select username, password from manager where exists (select username, password from manager where username = ? and password = ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, manager.getUsername());
        preparedStatement.setString(2, manager.getPassword());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            System.out.println("Login Successful");
            return true;
        } else {
            System.out.println("Login Failed");
            return false;
        }
    }

    @Override
    public List<Employee> viewAllEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String sql = "select empID, name, username from employee";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String username = resultSet.getString(3);
            Employee employee = new Employee(id, name, username);
            employees.add(employee);
        }
        return employees;
    }

    @Override
    public List<Requests> viewPendingRequests() throws SQLException {
        List<Requests> reimRequests = new ArrayList<>();
        String sql = "select * from reimbursement where status = 'pending'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int reimID = resultSet.getInt(1);
            int empID = resultSet.getInt(2);
            double amount = resultSet.getDouble(3);
            String subject = resultSet.getString(4);
            String status = resultSet.getString(5);
            Requests reimRequest = new Requests(reimID, empID, amount, subject, status);
            reimRequests.add(reimRequest);
        }
        return reimRequests;
    }

    @Override
    public List<Requests> viewResolvedRequests() throws SQLException {
        List<Requests> reimRequests = new ArrayList<>();
        String sql = "select * from reimbursement where status = 'approved' or status = 'denied'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int reimID = resultSet.getInt(1);
            int empID = resultSet.getInt(2);
            double amount = resultSet.getDouble(3);
            String subject = resultSet.getString(4);
            String status = resultSet.getString(5);
            Requests reimRequest = new Requests(reimID, empID, amount, subject, status);
            reimRequests.add(reimRequest);
        }
        return reimRequests;
    }


    @Override
    public List<Requests> viewEmployeeRequests(String empId) throws SQLException {

        List<Requests> reimRequests = new ArrayList<>();
        String sql = "select * from reimbursement where empID = " + empId;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int reimID = resultSet.getInt(1);
            int empID = resultSet.getInt(2);
            double amount = resultSet.getDouble(3);
            String subject = resultSet.getString(4);
            String status = resultSet.getString(5);
            Requests reimRequest = new Requests(reimID, empID, amount, subject, status);
            reimRequests.add(reimRequest);
        }
        if (resultSet == null){
            return null;
        }else{
            return reimRequests;
        }
    }

    @Override
    public boolean approveRequest(String reimID) throws SQLException {
        String sql = "update reimbursement set status = 'approved' where reimID = "+ reimID;
        Statement statement = connection.createStatement();
        int count = statement.executeUpdate(sql);
        if (count > 0){
            System.out.println("request updated");
            return true;
        }else{
            System.out.println("something went wrong");
            return false;
        }

    }


    @Override
    public boolean denyRequest(String reimID) throws SQLException {
        String sql = "update reimbursement set status = 'denied' where reimID = "+ reimID;
        Statement statement = connection.createStatement();
        int count = statement.executeUpdate(sql);
        if (count > 0){
            System.out.println("request updated");
            return true;
        }else{
            System.out.println("something went wrong");
            return false;
        }
    }
}
