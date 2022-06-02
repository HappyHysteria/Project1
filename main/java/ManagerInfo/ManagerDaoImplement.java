package ManagerInfo;

import Connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        if (resultSet.next() == true){
            System.out.println("Login Successful");
            return true;
        }else{
            System.out.println("Login Failed");
            return false;
        }
    }
}
