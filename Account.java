//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.util.Date;

class Account {

    private int id;
    private double balance;
    private static double annualInterestRate = 0.0;
    private Date dateCreated;

    public Account(int accountId, double startBalance) {
        this.id = accountId;
        this.balance = startBalance;
        this.dateCreated = new Date();
    }

    public int getId() {
        return this.id;
    }

    public double getBalance() {
        return this.balance;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public static void setAnnualInterestRate(double rate) {
        annualInterestRate = rate;
    }

    public Date getDateCreated() {
        return this.dateCreated;
    }

    public double getMonthlyInterestRate() {
        return annualInterestRate / (double)12.0F;
    }

    public double withdraw(double amount) {
        if (amount > this.balance) {
            amount = this.balance;
        }

        this.balance -= amount;
        return amount;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    @Override
    public String toString() {
        return "Account" + "id= " + id + "balance" + String.format("%.2f", balance) +
                "annualInterestRate= " + annualInterestRate + "dateCreated= " + dateCreated;
    }
}
