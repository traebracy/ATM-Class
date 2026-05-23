import java.util.ArrayList;
import java.util.Scanner;

public class Atm {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<Account> accounts = new ArrayList<>();
        // Account[] accounts = new Account[10];

        // Creates 10 accounts
        for (int i = 0; i < 10; i++) {

            if (i % 2 == 0) {
                accounts.add(new SavingsAccount(i, 100.0));

            } else {
                accounts.add(new CurrentAccount(i, 100.0, 50.0));
            }

        }

        while (true) {

            System.out.print("\nEnter an account id (0-9): ");

            int id = input.nextInt();

            while (id < 0 || id >= accounts.size()){

                System.out.print("That id doesn't exist. Please enter a valid id (0-9): ");
                id = input.nextInt();
            }

            boolean exit = false;

            while (!exit) {

                System.out.println("\n====================");
                System.out.println(" Main Menu (Account " + id + ")");
                System.out.println("====================");
                System.out.println("1) Check Balance");
                System.out.println("2) Withdraw");
                System.out.println("3) Deposit");
                System.out.println("4) Account Information");
                System.out.println("5) Exit (switch account)");
                System.out.print("Option: ");

                int choice = input.nextInt();

                Account selected = accounts.get(id);

                switch (choice) {

                    case 1 -> {
                        System.out.println("\nCurrent balance: $" + String.format("%.2f", selected.getBalance()));;
                    }

                    case 2 -> {
                        System.out.print("\nEnter amount to withdraw: ");

                        double amount = input.nextDouble();
                        double withdrawn = selected.withdraw(amount);

                        System.out.println("\nWithdrawn: $" + String.format("%.2f", withdrawn));
                        System.out.println("New balance: $" + String.format("%.2f", selected.getBalance()));
                    }

                    case 3 -> {
                        System.out.print("\nEnter amount to deposit: ");

                        double amount = input.nextDouble();

                        selected.deposit(amount);
                        System.out.println("\nDeposit accepted.");
                        System.out.println("New balance: $" + String.format("%.2f", selected.getBalance()));
                    }

                    case 4 -> {
                        System.out.println(selected);
                    }

                    case 5 -> exit = true;

                    default -> System.out.println("Not a valid option!");


                    }
                }
            }
        }
    }





/*

                if (choice == 1) {

                    System.out.println("\nCurrent balance: $" + selected.getBalance());

                } else if (choice == 2) {

                    System.out.print("Enter amount to withdraw: ");

                    double amount = input.nextDouble();
                    double withdrawn = selected.withdraw(amount);

                    System.out.println("Withdrawn: $" + withdrawn);
                    System.out.println("New balance: $" + selected.getBalance());

                } else if (choice == 3) {

                    System.out.print("Enter amount to deposit: ");

                    double amount = input.nextDouble();

                    selected.deposit(amount);
                    System.out.println("Deposit accepted.");

                    System.out.println("New balance: $" + selected.getBalance());

                } else if (choice == 4) {

                    System.out.println("\n--- Account Info ---");
                    System.out.println("Account ID: " + selected.getId());
                    System.out.println("Balance: $" + selected.getBalance());
                    System.out.println("Interest Rate: " + Account.getAnnualInterestRate());
                    System.out.println("Date Created: " + String.valueOf(selected.getDateCreated()));

                } else if (choice == 5) {

                    exit = true;

                } else {

                    System.out.println("Not a valid option!");
                }
            }
        }
    }
}

*/