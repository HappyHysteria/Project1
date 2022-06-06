package EmployeeInfo;

public class EmployeeDaoFactory {
    public static EmployeeDao employeedao;

    private EmployeeDaoFactory(){

    }
    public static EmployeeDao getEmployeeDao(){
        if (employeedao == null){
            employeedao = new EmployeeDaoImplement();
        }
        return employeedao;
    }
}
