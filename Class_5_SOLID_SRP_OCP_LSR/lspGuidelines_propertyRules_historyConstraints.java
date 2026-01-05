// Subclass methods should not be allowed state changes that
// the base class never allowed.
// taking the classic fixedDeposit Account example, where withdraw

interface Account {
    public void deposit(int amount);
    public void withDraw(int amount);
}


// This subclass follows History constraints as all methods of Parent class are properly defined here //
class savingsAccount implements Account {
    private int balance;
    public savingsAccount(int balance) {
        if (balance < 0) throw new RuntimeException("Balance can't be Negative !");
        this.balance = balance;
    }
    // Deposit allowed
    public void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited Rs." + amount + " to Savings Account. New Savings Account balance is Rs." + balance);
    }
    // Withdraw also allowed
    public void withDraw(int amount) {
        if (amount > balance) throw new RuntimeException("Insufficient funds");
        balance -= amount;
        System.out.println("Withdrew Rs." + amount + " from Savings Account. New Savings Account balance is Rs." + balance);
    }
}

// This One does not follow History constraints as the withDraw() method inherited from parent throws an Exception (Not allowed for fixed Deposit Account)
class fixedDepositAccount implements Account {
    private int balance;
    public fixedDepositAccount(int balance) {
        if (balance < 0) throw new RuntimeException("Balance can't be Negative !");
        this.balance = balance;
    }
    // Deposit allowed
    public void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited Rs." + amount + " to Fixed Deposit Account. New Fixed Deposit Account balance is Rs." + balance);
    }
    // Withdraw Not allowed
    public void withDraw(int amount) {
        throw new RuntimeException("Withdraw not allowed in Fixed Deposit Account !");
    }
}


public class lspGuidelines_propertyRules_historyConstraints {
    public static void main(String[] args) {
        Account savingsAccountObject = new savingsAccount(1200);
        Account fixedDepositAccountObject = new fixedDepositAccount(100);

        // Allowed in both
        savingsAccountObject.deposit(800);
        savingsAccountObject.withDraw(1900);
        fixedDepositAccountObject.deposit(90);

        // Allowed in only Savings Account, has to know that exception exists for type FixedDepositAccounts, So the class fixedDepositAccount does not follow History Constraints ➡️ Use an interface like NonWithDrawableAccount and inherit fixedDepositAccount from this. Then it will follow History Constraints.
        savingsAccountObject.withDraw(50);
        try {
            fixedDepositAccountObject.withDraw(890);
        } catch (RuntimeException e) {
            System.out.println(e);
        }
    }
}
