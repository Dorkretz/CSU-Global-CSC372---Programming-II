package src;

public class CheckingAccount extends BankAccount {
    // Interest
    private double interestRate;

    // Constructor
    public CheckingAccount(String firstName, String lastName, int accountID, double interestRate) {
        super(firstName, lastName, accountID);
        this.interestRate = interestRate;
    }

    // Overdraft fee
    public void processWithdrawal(double amount) {
        if (amount > 0) {
            if (amount > getBalance()) {
                System.out.println("You have overdrafted your account. A $30 fee will be applied.");
                double overdraftAmount = amount + 30;
                super.withdrawal(getBalance());
                System.out.println("New balance: -$" + overdraftAmount);
            } else {
                withdrawal(amount);
            }
        } else {
            System.out.println("Withdrawal amount must be a positive number.");
        }
    }

    // Account details and interest rate
    public void displayAccount() {
        accountSummary();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}