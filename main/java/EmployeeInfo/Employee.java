package EmployeeInfo;

public class Employee {
    private String name;
    private String username;
    private String password;
    private int requestreimburse;

    public Employee(){

    }

    public Employee(String name, String username, String password, int requestreimburse){
        this.name = name;
        this.username = username;
        this.password = password;
        this.requestreimburse = requestreimburse;
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

    public int getRequestreimburse(){
        return requestreimburse;
    }

    public void setRequestreimburse(int requestreimburse){ this.requestreimburse = requestreimburse; }

    @Override
    public String toString() {
        return "EmployeeInfo.Employee{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", requestreimburse=" + requestreimburse +
                '}';
    }
}
