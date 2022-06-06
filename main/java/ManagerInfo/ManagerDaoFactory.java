package ManagerInfo;

public class ManagerDaoFactory {
    public static ManagerDao dao;

    private ManagerDaoFactory(){

    }
    public static ManagerDao getDao(){
        if (dao == null){
            dao = new ManagerDaoImplement();
        }
        return dao;
    }
}
