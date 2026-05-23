public class SavingsAccount extends Account {

    private double minimumBalance = 100.00;

    public SavingsAccount(int accountId, double startBalance) {
        super(accountId, startBalance);

    }

    @Override
    public double withdraw(double amount) {

        if (getBalance() - amount < minimumBalance) {
            System.out.println("Cannot go below minimum balance of $100!");
            return 0;
        }

        return super.withdraw(amount);

    }

    @Override
    public String toString() {
        return "\n--- Savings Account ---" +
                "\nAccount ID: " + getId() +
                "\nBalance: $" + String.format("%.2f", getBalance()) +
                "\nMinimum Balance: $" + String.format("%.2f", minimumBalance) +
                "\nDate Created: " + getDateCreated();
    }
}

