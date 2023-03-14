package banking;

/**
 * Abstract bank account.
 */
public abstract class Account implements AccountInterface {
    private AccountHolder accountHolder;
    private Long accountNumber;
    private int pin;
    private double balance;

    protected Account(AccountHolder accountHolder, Long accountNumber, int pin, double startingDeposit) {
        // TODO: complete the constructor
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance=startingDeposit;

    }

    public AccountHolder getAccountHolder() {
        // TODO: complete the method
        return this.accountHolder;
    }

    public boolean validatePin(int attemptedPin) {
        // TODO: complete the method
        return this.pin==attemptedPin;
    }

    public double getBalance() {
        // TODO: complete the method
        return this.balance;
    }

    public Long getAccountNumber() {
        // TODO: complete the method
        return this.accountNumber;
    }

    public void creditAccount(double amount) {
        this.balance += amount;
    }

    public boolean debitAccount(double amount) {
        // TODO: complete the method
        if (this.balance-amount>=0){
            this.balance-=amount;
            return true;
        }
        return false;
    }
}
