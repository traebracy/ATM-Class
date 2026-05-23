public class CurrentAccount extends Account {

    private double overdraftLimit;

    public CurrentAccount(int accountId, double startBalance, double overdraftLimit) {
        super(accountId, startBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public double withdraw(double amount) {

        if (amount <= 0)
            return 0;

        double available = getBalance() + overdraftLimit;

        if (amount > available)
            amount = available;

        deposit(-amount);
        return amount;
    }

    @Override
    public String toString() {
        return "\n--- Current Account ---" +
                "\nAccount ID: " + getId() +
                "\nBalance: $" + String.format("%.2f", getBalance()) +
                "\nOverdraft Limit: $" + String.format("%.2f", overdraftLimit) +
                "\nDate Created: " + getDateCreated();
    }
}
