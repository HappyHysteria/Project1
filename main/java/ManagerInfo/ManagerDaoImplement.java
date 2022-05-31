package ManagerInfo;

import ConnectionInfo.ConnectionFactory;

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
    public void managerLogin(Manager manager) throws SQLException {
        String sql = "select * from manager where username = ? && password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, manager.getUsername());
        preparedStatement.setString(2, manager.getPassword());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){

        }
    }
}
