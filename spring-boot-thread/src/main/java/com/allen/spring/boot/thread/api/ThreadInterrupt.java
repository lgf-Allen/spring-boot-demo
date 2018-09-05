package com.allen.spring.boot.thread.api;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ThreadInterrupt {

    public static void main(String[] args) throws InterruptedException {

        interruptTest();
        
//        isInterruptTest();
        
    }
    
    public static void interruptTest() throws InterruptedException {
        Thread thread = new Thread(() -> {
//            try {
//                TimeUnit.MINUTES.sleep(1);
//            }catch(InterruptedException e) {
//                System.out.println("I am be interrupted.");
//            }
            while(true) {
                System.out.println(Thread.interrupted());
            }
        }) ;
        thread.setDaemon(true);
        thread.start();
        TimeUnit.MILLISECONDS.sleep(2);
        thread.interrupt();
    }

    public static void isInterruptTest() throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                while(true) {
                    
                }
            }
        };
        thread.setDaemon(true);
        thread.start();
        TimeUnit.MILLISECONDS.sleep(2);
        System.out.printf("Thread is interrupted ? %s\n" , thread.isInterrupted());
        thread.interrupt();
        System.out.printf("Thread is interrupted ? %s\n" , thread.isInterrupted());
    }
}
