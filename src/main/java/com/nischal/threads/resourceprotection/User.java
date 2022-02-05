package com.nischal.threads.resourceprotection;

public class User implements Runnable {

    private Account account;
    private Transaction transaction;

    @Override
    public void run() {
        transaction.process(account);
        System.out.println("the balance after transaction is " + account.getBalance());
    }

    public User(Account account, Transaction transaction) {
        this.account = account;
        this.transaction = transaction;
    }

    public User() {
    }
}
