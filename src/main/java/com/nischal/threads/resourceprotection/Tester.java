package com.nischal.threads.resourceprotection;

public class Tester {

    public static void main(String[] args) {

        Account nischalAccount = new Account(50);

        Transaction deposit = ((account) -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Thread " + Thread.currentThread().getName() + " is performing deposit");
                account.deposit(10);
                System.out.println("initial balance after " + i + " th deposit by = " + Thread.currentThread().getName() + " is " + account.getBalance());
            }
        });

        Transaction withraw = ((account) -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Thread " + Thread.currentThread().getName() + " is perfrming withdrawal");
                account.withdraw(10);
                System.out.println("initial balance after" + i + " th withdraw by - " + Thread.currentThread().getName() + " is " + account.getBalance());
            }
        });

        Thread user1 = new Thread(new User(nischalAccount, deposit));
        Thread user2 = new Thread(new User(nischalAccount, withraw));
        user1.start();
        user2.start();
    }
}
