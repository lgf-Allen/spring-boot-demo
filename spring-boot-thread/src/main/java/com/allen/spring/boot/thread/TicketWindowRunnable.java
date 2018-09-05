package com.allen.spring.boot.thread;

import java.util.concurrent.TimeUnit;

public class TicketWindowRunnable implements Runnable {

    private static final int MAX = 50;
    
    private final static Object MUTEX = new Object();
    private int index = 1;
    @Override
    public void run() {
        // add synchronized block
        synchronized(MUTEX) {
            while (index <= MAX) {
                System.out.println(Thread.currentThread() + "的号码是:" + (index++));
                try {
                    // Thread.sleep(100);
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        final TicketWindowRunnable runnable = new TicketWindowRunnable();
        Thread thread1 = new Thread(runnable , "一号窗口");
        Thread thread2 = new Thread(runnable , "二号窗口");
        Thread thread3 = new Thread(runnable , "三号窗口");
        Thread thread4 = new Thread(runnable , "四号窗口");
        thread2.start();
        thread1.start();
        thread3.start();
        thread4.start();
        
        
    }

}
