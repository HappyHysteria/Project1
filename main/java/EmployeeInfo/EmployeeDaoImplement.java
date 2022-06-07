package EmployeeInfo;

import ConnectionInfo.ConnectionFactory;
import Reimbursements.Requests;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImplement implements EmployeeDao {
    Connection connection;

    public EmployeeDaoImplement(){
        this.connection = ConnectionFactory.getConnection();
    }

    @Override
    public void login(Employee employee, HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        PrintWriter out = response.getWriter();
        String sql = "select * from employee where username = ? && password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, employee.getUsername());
        preparedStatement.setString(2, employee.getPassword());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            int id = resultSet.getInt(1);
            Cookie cookie = new Cookie("id", String.valueOf(id));
            response.addCookie(cookie);
            out.println("Welcome " + resultSet.getString(2));
            request.getRequestDispatcher("employeehome.html").include(request, response);
            request.getRequestDispatcher("nav.html").include(request, response);
        } else {
            out.println("Invalid login information");
            request.getRequestDispatcher("employeelogin.html").include(request, response);
        }
    }

    @Override
    public List<Employee> info(String user, HttpServletRequest request, HttpServletResponse response) throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String sql = "select * from employee where username = '" + user + "'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String username = resultSet.getString(3);
            String password = resultSet.getString(4);
            Employee employee = new Employee(id, name, username, password);
            employees.add(employee);
        }
        return employees;
    }

    @Override
    public void updateInfo(String user, String pass, HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        PrintWriter out = response.getWriter();
        String sql = "update employee set password = '" + pass + "' where username = '" + user + "'";
        Statement statement = connection.createStatement();
        int count = statement.executeUpdate(sql);
        if (count > 0){
            out.println("Password updated");
        } else {
            out.println("Error updating password");
        }
        request.getRequestDispatcher("employeeprofile.html").include(request, response);
    }

    @Override
    public void requestReimbursement(double reqAmount, String subject, HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        PrintWriter out = response.getWriter();
        Cookie[] cookies = request.getCookies();
        String id = cookies[1].getValue();
        int empid = Integer.parseInt(id);

        String sql = "insert into reimbursement (empID, amount, subject) values (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, empid);
        preparedStatement.setDouble(2, reqAmount);
        preparedStatement.setString(3, subject);
        int count = preparedStatement.executeUpdate();
        if (count > 0){
            out.println("Request submitted to management");
        } else {
            out.println("Error with reimbursement request");
        }
        request.getRequestDispatcher("employeeprofile.html").include(request, response);
    }

    @Override
    public List<Requests> requests(int empid, HttpServletRequest request, HttpServletResponse response) throws SQLException {
        List<Requests> requestList = new ArrayList<>();
        String sql = "select * from reimbursement where empID = " + empid;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            int reimid = resultSet.getInt(1);
            double amount = resultSet.getDouble(3);
            String subject = resultSet.getString(4);
            String status = resultSet.getString(5);
            Requests requests = new Requests(reimid, amount, subject, status);
            requestList.add(requests);
        }
        return requestList;
    }

}
