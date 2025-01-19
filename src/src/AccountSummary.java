package src;

public class AccountSummary {
    public static void main(String[] args) {

        // BankAccount instance
        BankAccount bankAccount = new BankAccount("Dorian", "Mathews", 8675309);
        bankAccount.deposit(500);
        bankAccount.withdrawal(300);
        bankAccount.accountSummary();

        System.out.println("\n");

        // CheckingAccount instance
        CheckingAccount checkingAccount = new CheckingAccount("Bob", "Marley", 778952, 1.5);
        checkingAccount.deposit(200);
        checkingAccount.withdrawal(350);
        checkingAccount.displayAccount();

        System.out.println("\nAttempting overdraft...");
        checkingAccount.processWithdrawal(150);
        checkingAccount.displayAccount();
    }
}