import java.util.ArrayList;
import java.util.List;

interface nonWithDrawableAccount {
  void deposit(int amount);
}

interface withDrawableAccount extends nonWithDrawableAccount {
  // Has deposit() already from nonWithDrawableAccount
  void withDraw(int amount);
}

// Fixed Deposit Account is non-withdrawable
class fixedDepositAccount implements nonWithDrawableAccount {
  private int balance;
  // Constructor
  public fixedDepositAccount(int balance) {
    this.balance = balance;
    System.out.println("Fixed-Deposit-Account Balance: Rs." + this.balance);
  }
  // Definition of deposit() to deposit money in fixedDeposit Balance
  @Override
  public void deposit(int amount) {
    balance += amount;
    System.out.printf(
        "Deposited %d to Fixed Deposit Account, new Balance is Rs. %d\n",
        amount, balance);
  }
}

// Savings Account and Salary Account are withdrawable
class savingsAccount implements withDrawableAccount {
  private int balance;
  public savingsAccount(int balance) {
    this.balance = balance;
    System.out.println("Savings-Account Balance: Rs." + this.balance);
  }

  @Override
  public void deposit(int amount) {
    balance += amount;
    System.out.printf(
        "Deposited %d to Savings Account, new Balance is Rs. %d\n", amount,
        balance);
  }

  @Override
  public void withDraw(int amount) {
    if (balance >= amount) {
      balance -= amount;
      System.out.printf(
          "Withdrew %d from Savings Account, new Balance is Rs. %d\n", amount,
          balance);
    } else
      System.out.println("Not Enough Balance in Savings Account to withdraw Rs."+amount);
  }
}

class salaryAccount implements withDrawableAccount {
  private int balance;
  public salaryAccount(int balance) {
    this.balance = balance;
    System.out.println("Salary-Account Balance: Rs." + this.balance);
  }
  @Override
  public void deposit(int amount) {
    this.balance += amount;
    System.out.printf("Deposited %d to Salary Account, new Balance is Rs. %d\n",
        amount, balance);
  }
  @Override
  public void withDraw(int amount) {
    if (this.balance >= amount) {
      this.balance -= amount;
      System.out.printf(
          "Withdrew %d from Salary Account, new Balance is Rs. %d\n", amount,
          balance);
    } else
      System.out.println("Not Enough Balance in Salary Account to withdraw Rs."+amount);
  }
}

class BankClient {
  private List<withDrawableAccount> withDrawableAccounts;
  private List<nonWithDrawableAccount> nonWithDrawableAccounts;
  public BankClient(
      List<withDrawableAccount> wda, List<nonWithDrawableAccount> nwda) {
    this.withDrawableAccounts = wda;
    this.nonWithDrawableAccounts = nwda;
  }
  public void processTransaction() {
    System.out.println();
    for (withDrawableAccount a : withDrawableAccounts) {
      a.deposit(5);
      a.deposit(10);
      a.withDraw(15);
      a.withDraw(15);
      a.withDraw(4000);
      System.out.println();
    }
    for (nonWithDrawableAccount a : nonWithDrawableAccounts) {
      a.deposit(5);
      a.deposit(10);
      System.out.println();
    }
  }
}

public class lspfollowed {
  public static void main(String[] args) {
    System.out.println();
    withDrawableAccount clientSavingsAccount = new savingsAccount(1000);
    withDrawableAccount clientSalaryAccount = new salaryAccount(500);
    nonWithDrawableAccount clientFixedDepositAccount =
        new fixedDepositAccount(300);

    List<withDrawableAccount> clientWithDrawableAccounts =
        new ArrayList<withDrawableAccount>();
    List<nonWithDrawableAccount> clientNonWithDrawableAccounts =
        new ArrayList<nonWithDrawableAccount>();

    clientWithDrawableAccounts.add(clientSavingsAccount);
    clientWithDrawableAccounts.add(clientSalaryAccount);
    clientNonWithDrawableAccounts.add(clientFixedDepositAccount);

    BankClient client = new BankClient(
        clientWithDrawableAccounts, clientNonWithDrawableAccounts);
        client.processTransaction();
  }
}
