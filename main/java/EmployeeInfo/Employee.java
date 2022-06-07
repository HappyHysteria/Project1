package EmployeeInfo;

public class Employee {
<<<<<<< HEAD
    private int ID;
=======
    private int empid;
>>>>>>> 0bc4995f5066b4d703fcd3bace921ad4b6e2e1d7
    private String name;
    private String username;
    private String password;

    public Employee(){

    }

<<<<<<< HEAD
    public Employee(int ID, String name, String username){
        this.ID = ID;
        this.name = name;
        this.username = username;

    }

    public Employee(int ID, String name, String username, String password){
        this.ID = ID;
        this.name = name;
        this.username = username;
        this.password = password;

    }

=======
    public Employee(int empid, String name, String username){
        this.empid = empid;
        this.name = name;
        this.username = username;
    }

    public Employee(int empid, String name, String username, String password){
        this.empid = empid;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public int getEmpid(){
        return empid;
    }

    public void setEmpid(int empid){ this.empid = empid; }

>>>>>>> 0bc4995f5066b4d703fcd3bace921ad4b6e2e1d7
    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){ this.password = password; }

<<<<<<< HEAD
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ID=" + ID +
=======
    @Override
    public String toString() {
        return "Employee{" +
                "empid=" + empid +
>>>>>>> 0bc4995f5066b4d703fcd3bace921ad4b6e2e1d7
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
