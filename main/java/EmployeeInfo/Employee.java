package EmployeeInfo;

public class Employee {
    private int ID;
    private String name;
    private String username;
    private String password;

    public Employee(){

    }

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
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
