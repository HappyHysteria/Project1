import java.sql.SQLException;

public interface Dao {
    void login (Employee employee) throws SQLException;
    void managerLogin (Manager manager) throws SQLException;
}
