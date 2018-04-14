package com.epam.java.core7.task1;

public class Account {

    private final long id;
    private final double amount;
    private final String owner;

    public Account(long id, double amount, String owner) {
        this.id = id;
        this.amount = amount;
        this.owner = owner;
    }

    public Account(Account old, double amount) {
        this(old.getId(), amount, old.owner);
    }

    public long getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", amount=" + amount +
                ", owner='" + owner + '\'' +
                '}';
    }
}
