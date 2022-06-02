package Reimbursements;

public class ReimRequest {
    private int reimID;
    private int empID;
    private double amount;
    private String subject;
    private String status;

    public ReimRequest() {
    }

    public ReimRequest(int reimID, int empID, double amount, String subject, String status) {
        this.reimID = reimID;
        this.empID = empID;
        this.amount = amount;
        this.subject = subject;
        this.status = status;
    }

    public int getReimID() {
        return reimID;
    }

    public void setReimID(int reimID) {
        this.reimID = reimID;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public double getAmount() {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Request{" +
                "reimID=" + reimID +
                ", empID=" + empID +
                ", amount=" + amount +
                ", subject='" + subject + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
