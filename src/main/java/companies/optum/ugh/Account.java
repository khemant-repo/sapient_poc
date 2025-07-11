package companies.optum.ugh;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

class Account {
    private final int accountId;
    private final String name;
    private double balance;

    public Account(int accountId, String name, double initialBalance) {
        this.accountId = accountId;
        this.name = name;
        this.balance = initialBalance;
    }

    public int getAccountId() {
        return accountId;
    }

    public String getName() {
        return name;
    }

    public synchronized double getBalance() {
        return balance;
    }

    public synchronized void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit must be positive");
        balance += amount;
    }

    public synchronized void withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Withdraw must be positive");
        if (balance < amount) throw new IllegalArgumentException("Insufficient funds");
        balance -= amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}

class BankService {
    private final Map<Integer, Account> accounts = new HashMap<>();
    private final AtomicInteger idGenerator = new AtomicInteger(1000);

    public Account createAccount(String name, double initialDeposit) {
        if (initialDeposit < 0) throw new IllegalArgumentException("Initial deposit cannot be negative");
        int id = idGenerator.getAndIncrement();
        Account acc = new Account(id, name, initialDeposit);
        accounts.put(id, acc);
        return acc;
    }

    public void depositAmount(int accountId, double amount) {
        Account acc = getAccount(accountId);
        acc.deposit(amount);
    }

    public void transferMoney(int fromId, int toId, double amount) {
        if (fromId == toId) throw new IllegalArgumentException("Cannot transfer to same account");
        Account from = getAccount(fromId);
        Account to = getAccount(toId);
        synchronized (from) {
            synchronized (to) {
                from.withdraw(amount);
                to.deposit(amount);
            }
        }
    }

    public Account getTopSpender() {
        accounts.values().stream().forEach(acc-> {
            System.out.println("Acc details : "+acc);
        });


        return accounts.values().stream()
                .max(Comparator.comparingDouble(Account::getBalance))
                .orElseThrow(() -> new IllegalStateException("No accounts available"));
    }

    public double getBalance(int accountId) {
        return getAccount(accountId).getBalance();
    }

    private Account getAccount(int accountId) {
        Account acc = accounts.get(accountId);
        if (acc == null) throw new NoSuchElementException("Account not found: " + accountId);
        return acc;
    }
}

// Test class
class BankServiceTest {
    public static void main(String[] args) {
        BankService bank = new BankService();

        // Create accounts
        Account a1 = bank.createAccount("Alice", 500);
        Account a2 = bank.createAccount("Bob", 1000);
        Account a3 = bank.createAccount("tom", 1080);
        Account a4 = bank.createAccount("holland", 1010);
        assert bank.getBalance(a1.getAccountId()) == 500;
        assert bank.getBalance(a2.getAccountId()) == 1000;

        // Deposit
        bank.depositAmount(a1.getAccountId(), 200);
        assert bank.getBalance(a1.getAccountId()) == 700;

        // Transfer
        bank.transferMoney(a2.getAccountId(), a1.getAccountId(), 300);
        assert bank.getBalance(a1.getAccountId()) == 1000;
        assert bank.getBalance(a2.getAccountId()) == 700;

        // Top spender (lowest balance)
        Account topSpender = bank.getTopSpender();
        System.out.println("top spender: "+topSpender);
        assert topSpender.getAccountId() == a2.getAccountId();

        // Edge Cases
        try {
            bank.depositAmount(a1.getAccountId(), -10);
            assert false;
        } catch (IllegalArgumentException e) {
            assert e.getMessage().equals("Deposit must be positive");
        }

        try {
            bank.transferMoney(a1.getAccountId(), a1.getAccountId(), 50);
            assert false;
        } catch (IllegalArgumentException e) {
            assert e.getMessage().equals("Cannot transfer to same account");
        }

        try {
            bank.transferMoney(a2.getAccountId(), a1.getAccountId(), 10000);
            assert false;
        } catch (IllegalArgumentException e) {
            assert e.getMessage().equals("Insufficient funds");
        }

        System.out.println("All tests passed successfully.");
    }
}
