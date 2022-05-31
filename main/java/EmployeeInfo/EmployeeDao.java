package EmployeeInfo;

import java.sql.SQLException;

public interface EmployeeDao {
    void login (Employee employee) throws SQLException;
}
