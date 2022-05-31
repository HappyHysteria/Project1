package ManagerInfo;

import java.sql.SQLException;

public interface ManagerDao {
    void managerLogin(Manager manager) throws SQLException;
}
