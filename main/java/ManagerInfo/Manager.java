package ManagerInfo;

public class Manager {
    private int managerID;
    private String username;
    private String password;

    public Manager(){

    }

    public Manager(int managerID, String username, String password){
        this.managerID = managerID;
        this.username = username;
        this.password = password;
    }

<<<<<<< HEAD

=======
>>>>>>> 0bc4995f5066b4d703fcd3bace921ad4b6e2e1d7
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

    public int getManagerID() {
        return managerID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "managerID=" + managerID +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
