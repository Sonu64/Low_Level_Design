// Class Invariant of a parent class Object should not be broken by child class Object.
// Hence child class can either maintain or strengthen the invariant but never narrows it down.

// Invariant: Balance cannot be negative
class Account {
    protected int balance;
    public Account(int balance) {
        if (balance < 0) throw new IllegalArgumentException("Balance can't be Nagative !");
        this.balance = balance;
    }
    public void withdraw(int amount) {
        if (amount > balance) throw new RuntimeException("Insufficient Funds !");
        else {
            balance -= amount;
        System.out.printf("\nWithdrew Rs.%d from Rs.%d. New Balance is Rs.%d.", amount, balance+amount, balance);
        }
    }
}

class FixedDepositAccount extends Account {
    // Explicit sub-class Constructor needed as the implicit call to super() occurs only for No-argument constructors.
    public FixedDepositAccount(int balance) {
        super(balance);
    }
    // balance exists here because of being protected
    public void withdraw(int amount) {
        balance -= amount;
        System.out.printf("\nWithdrew Rs.%d from Rs.%d. New Balance is Rs.%d.", amount, balance+amount, balance);
    }
}

class Client {
    private Account acc;
    public Client(Account acc) {
        this.acc = acc;
    }
    public void processWithdraw(int amount) {
        acc.withdraw(amount);
    }
}





public class lspGuidelines_propertyRules_classInvariants {
    public static void main(String[] args) {
        Account normalAccount = new Account(1000);
        Account fixedDepositAccount = new FixedDepositAccount(1000);

        Client clientFromChild = new Client(fixedDepositAccount);
        clientFromChild.processWithdraw(500);
        clientFromChild.processWithdraw(500);
        clientFromChild.processWithdraw(1000);


    }
}
