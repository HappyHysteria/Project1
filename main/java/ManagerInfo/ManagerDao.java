package ManagerInfo;

import java.sql.SQLException;

public interface ManagerDao {
    boolean managerLogin(Manager manager) throws SQLException;
}
