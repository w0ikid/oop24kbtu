package lab2.part3;

import java.util.Vector;

class Account {
    private double balance;
    private int accNumber;

    public Account(int accNumber) {
        this.balance = 0.0;
        this.accNumber = accNumber;
    }

    public void deposit(double sum) {
        if (sum > 0) {
            balance += sum;
            System.out.println("Deposited: $" + sum);
        }
    }

    public void withdraw(double sum) {
        if (sum > 0 && sum <= balance) {
            balance -= sum;
            System.out.println("Withdrew: $" + sum);
        } else {
            System.out.println("bedniy");
        }
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accNumber;
    }

    public void transfer(double amount, Account other) {
        if (amount > 0 && amount <= balance) {
            withdraw(amount);
            other.deposit(amount);
            System.out.println("Transferred: $" + amount + " to Account #" + other.getAccountNumber());
        } else {
            System.out.println("error due");
        }
    }

    @Override
    public String toString() {
        return "Account #" + accNumber + ", Balance: $" + balance;
    }

    public final void print() {
        System.out.println(toString());
    }
}

class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(int accNumber, double interestRate) {
        super(accNumber);
        this.interestRate = interestRate;
    }

    public void addInterest() {
        double interest = getBalance() * interestRate / 100;
        deposit(interest);
        System.out.println("Interest added: $" + interest);
    }

    @Override
    public String toString() {
        return "Savings " + super.toString() + " Interest Rate: " + interestRate + "%";
    }
}

class CheckingAccount extends Account {
    private int transactionCount;
    private static final int FREE_TRANSACTIONS = 3;
    private static final double TRANSACTION_FEE = 0.02;

    public CheckingAccount(int accNumber) {
        super(accNumber);
        this.transactionCount = 0;
    }

    @Override
    public void deposit(double sum) {
        super.deposit(sum);
        transactionCount++;
        deductFee();
    }

    @Override
    public void withdraw(double sum) {
        super.withdraw(sum);
        transactionCount++;
        deductFee();
    }

    public void deductFee() {
        if (transactionCount > FREE_TRANSACTIONS) {
            double fee = getBalance() * TRANSACTION_FEE;
            super.withdraw(fee);
            System.out.println("Transaction fee deducted: $" + fee);
        }
    }

    @Override
    public String toString() {
        return "Checking " + super.toString() + " Transactions: " + transactionCount;
    }
}

class Bank {
    private Vector<Account> accounts;

    public Bank() {
        accounts = new Vector<>();
    }

    public void openAccount(Account account) {
        accounts.add(account);
        System.out.println("Opened new account: " + account);
    }

    public void closeAccount(int accNumber) {
        int left = 0;
        int right = accounts.size() - 1;
    
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midAccNumber = accounts.get(mid).getAccountNumber();
    
            if (midAccNumber == accNumber) {
                accounts.remove(mid);
                System.out.println("Closed account #" + accNumber);
                return;
            } else if (midAccNumber < accNumber) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    
        System.out.println("Account #" + accNumber + " not found");
    }

    public void updateAccounts() {
        for (Account account : accounts) {
            if (account instanceof SavingsAccount) {
                ((SavingsAccount) account).addInterest();
            } else if (account instanceof CheckingAccount) {
                ((CheckingAccount) account).deductFee();
            }
        }
    }

    public void printAccounts() {
        System.out.println("Bank Accounts:");
        for (Account account : accounts) {
            account.print();
        }
    }
}

public class BankSystemTest {
    public static void main(String[] args) {
        // Bank bank = new Bank();

        // account checking account
        
        Account account = new Account(0);
        CheckingAccount something = (CheckingAccount) account;
        System.out.println((something));
        // SavingsAccount savingsAccount = new SavingsAccount(1001, 5.0);  // 5% interest
        // CheckingAccount checkingAccount = new CheckingAccount(1002);

        // bank.openAccount(savingsAccount);
        // bank.openAccount(checkingAccount);

        // savingsAccount.deposit(1000);
        // checkingAccount.deposit(500);

        // checkingAccount.withdraw(50);
        // checkingAccount.deposit(200);
        // checkingAccount.withdraw(100);

        // bank.updateAccounts();

        // bank.printAccounts();
    }
}
