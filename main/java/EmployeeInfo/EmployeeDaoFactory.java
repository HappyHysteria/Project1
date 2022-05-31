package EmployeeInfo;

public class EmployeeDaoFactory {
    public static EmployeeDao dao;

    private EmployeeDaoFactory(){

    }
    public static EmployeeDao getDao(){
        if (dao == null){
            dao = new EmployeeDaoImplement();
        }
        return dao;
    }
}
