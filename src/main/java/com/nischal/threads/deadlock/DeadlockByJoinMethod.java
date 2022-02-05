package com.nischal.threads.deadlock;

public class DeadlockByJoinMethod {

    public static void main(String[] args){
        Thread thread1 = new Thread(new RunnableImpl(Thread.currentThread()));
        try {
            System.out.println("printed by main thread");
            thread1.start();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class RunnableImpl implements Runnable{
    Thread thread;

    @Override
    public void run() {
        try {
            thread.join();
            System.out.println("printed by "+ Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public RunnableImpl(Thread thread){
        this.thread = thread;
    }
}
