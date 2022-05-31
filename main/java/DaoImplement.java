import java.sql.*;

public class DaoImplement implements Dao{
    Connection connection;

    public DaoImplement(){
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
