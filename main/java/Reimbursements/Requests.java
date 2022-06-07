package Reimbursements;

public class Requests {
    private int reimid;
    private int empid;
    private double amount;
    private String subject;
    private String status;

    public Requests(){

    }

    public Requests(int reimid, int empid, double amount, String subject, String status) {
        this.empid = empid;
        this.reimid = reimid;
        this.amount = amount;
        this.subject = subject;
        this.status = status;
    }
    public Requests(int reimid, double amount, String subject, String status) {
        this.reimid = reimid;
        this.amount = amount;
        this.subject = subject;
        this.status = status;
    }
    public int getReimid(){
        return reimid;
    }

    public void setReimid(int reimid){ this.reimid = reimid; }

    public int getEmpid(){
        return empid;
    }

    public void setEmpid(int empid){ this.empid = empid; }

    public double getAmount(){
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){ this.status = status; }

    @Override
    public String toString() {
        return "Requests{" +
                "reimid=" + reimid +
                ", amount=" + amount +
                ", subject='" + subject + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
