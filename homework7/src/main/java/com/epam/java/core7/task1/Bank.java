package com.epam.java.core7.task1;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank implements AutoCloseable {

    private final Map<Long, Account> accounts;
    private final String accountFile;
    private Lock lock = new ReentrantLock();

    public Bank(String filePath) {
        this.accountFile = filePath;
        this.accounts = readAccountFile(filePath);
    }

    public Map<Long, Account> getAccounts() {
        return Collections.unmodifiableMap(accounts);
    }

    public synchronized void addAccount(Account account) {
//        lock.lock();
//        try {
            if (accounts.containsKey(account.getId())) {
                throw new IllegalArgumentException("Account already exists");
            }
            accounts.put(account.getId(), account);
//        } finally {
//          lock.unlock();
//        }
    }

    public synchronized void transfer(long from, long to, double sum) {
//        lock.lock();
//        try {
            if (!accounts.containsKey(from) || !accounts.containsKey(to)) {
                throw new IllegalArgumentException("There are no such account");
            }
            Account sourceAccount = accounts.get(from);
            Account destAccount = accounts.get(to);
            if (sourceAccount.getAmount() - sum < 0) {
                throw new IllegalArgumentException(String.format("Not enough money on account %d", from));
            }
            accounts.put(sourceAccount.getId(), new Account(sourceAccount, sourceAccount.getAmount() - sum));
            accounts.put(destAccount.getId(), new Account(destAccount, destAccount.getAmount() + sum));
//        } finally {
//          lock.unlock();
//        }
    }

    @Override
    public void close() {
        File file = new File(accountFile);
        if (!file.isFile() || !file.exists()) {
            throw new IllegalArgumentException("There is no such file");
        }
        try (FileWriter writer = new FileWriter(file)) {
            for (Account account : accounts.values()) {
                String line = String.format(Locale.ROOT, "%d %.2f %s\n", account.getId(),
                        account.getAmount(), account.getOwner());
                writer.write(line);
            }
        } catch (IOException e) {
            System.err.println("Failed to edit file: " + e.getMessage());
        }
    }

    private Map<Long, Account> readAccountFile(String filePath) {
        Map<Long, Account> accounts = new HashMap<>();
        File file = new File(filePath);
        if (!file.isFile() || !file.exists()) {
            throw new IllegalArgumentException("There is no such file");
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            while (line != null) {
                String[] strings = line.split("\\s+", 3);
                Long id = Long.parseLong(strings[0]);
                Double amount = Double.parseDouble(strings[1]);
                accounts.put(id, new Account(id, amount, strings[2]));
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.err.println("Failed to view file: " + e.getMessage());
        }
        return accounts;
    }
}
