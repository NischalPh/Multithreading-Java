package com.nischal.multithreading.threadbasics;

import java.util.Date;

public class Painter extends Thread {

    private String name;
    private String painting;
    private long timeTaken;

    public Painter(String painting, String name, long timeTaken) {
        this.painting = painting;
        this.name = name;
        this.timeTaken = timeTaken;
    }

    @Override
    public void run() {
        paint();
    }

    public void paint() {
        String name = Thread.currentThread().getName();
        System.out.println("painter " + name + " Started painting at " + new Date().getTime());
        System.out.println("painter -" + name + " is painting house");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.getMessage();
        }
        System.out.println("painter "+name+ " finished painting at "+new Date().getTime());
    }
}
