package assignment_shoaib_akhtar;

import java.util.Date;

public class LoanAccount {
    private Date dueDate;
    private double outstandingBalance;
    private String accountId;

    public Date getDueDate() {
        return this.dueDate;
    }

    public double getOutstandingBalance() {
        return this.outstandingBalance;
    }

    public String getAccountId() {
        return this.accountId;
    }
}
