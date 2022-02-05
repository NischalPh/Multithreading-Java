package com.nischal.threads.deadlock;

public class DeadlockDemo {

    public static void main(String[] args) {
        String resource1 = "Nischal";
        String resource2 = "Phuyal";

        Thread thread1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println(resource1 + " printed by " + Thread.currentThread().getName());
                synchronized (resource2) {
                    System.out.println(resource2);
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println(resource2 + " printed by " + Thread.currentThread().getName());
                synchronized (resource1) {
                    System.out.println(resource1);
                }
            }
        });

        thread1.start();
        thread2.start();

        System.out.println("this is printed by " + Thread.currentThread().getName());
    }
}
