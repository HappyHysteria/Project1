package EmployeeInfo;

public class EmployeeDaoFactory {
<<<<<<< HEAD
    public static EmployeeDao dao;
=======
    public static EmployeeDao employeedao;
>>>>>>> 0bc4995f5066b4d703fcd3bace921ad4b6e2e1d7

    private EmployeeDaoFactory(){

    }
<<<<<<< HEAD
    public static EmployeeDao getDao(){
        if (dao == null){
            dao = new EmployeeDaoImplement();
        }
        return dao;
=======
    public static EmployeeDao getEmployeeDao(){
        if (employeedao == null){
            employeedao = new EmployeeDaoImplement();
        }
        return employeedao;
>>>>>>> 0bc4995f5066b4d703fcd3bace921ad4b6e2e1d7
    }
}
