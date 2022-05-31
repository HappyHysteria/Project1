package EmployeeInfo;

import ConnectionInfo.ConnectionFactory;
import java.sql.*;

public class EmployeeDaoImplement implements EmployeeDao {
    Connection connection;

    public EmployeeDaoImplement(){
        this.connection = ConnectionFactory.getConnection();
    }

    @Override
    public void login(Employee employee) throws SQLException {
        String sql = "select * from employee where username = ? && password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, employee.getUsername());
        preparedStatement.setString(2, employee.getPassword());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){

        }
    }

}
