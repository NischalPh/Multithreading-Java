package com.nischal.multithreading.threadbasics;

public class Main {
    public static void main(String[] args) {

        Painter p;
        for(int i=0; i<=5; i++){
            p= new Painter("monalisa - "+i, "nischal-"+i,5000 );
            System.out.println("the state of the thread before starting is "+ p.getState());
            p.start();
            System.out.println("the state of the thread after starting is "+ p.getState());
        }
    }
}
