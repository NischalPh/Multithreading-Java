package com.nischal.threads.resourceprotection;

import java.util.concurrent.atomic.AtomicInteger;

public class Account {

    private final Object object = new Object();

    private AtomicInteger balance = new AtomicInteger();

    public Account(int balance) {
        this.balance.set(balance);
    }

    public int getBalance() {
        return balance.get();
    }

    public void deposit(int amount) {
        synchronized (object) {
            balance.set(balance.get() + amount);
        }
    }

    public void withdraw(int amount) {
        synchronized (object) {
            balance.set(balance.get() - amount);
        }
    }
}
