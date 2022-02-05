package com.nischal.threads.threadbasics;

public class JoinMethodDemo {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("this run method is executed by " + Thread.currentThread().getName());
            Thread t1 = new Thread(() -> {
                System.out.println("this is printed by " + Thread.currentThread().getName());
            });
            try {
                // thread 1 and thread 2 will not finish its execution until t1 and t2 finishes.
                t1.join();
                t1.start();
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("thread " + Thread.currentThread().getName() + " has finished execution");
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("this is printed by " + Thread.currentThread().getName());
    }
}
