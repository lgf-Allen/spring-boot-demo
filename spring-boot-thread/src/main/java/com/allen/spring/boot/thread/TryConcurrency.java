/**
 * 
 */
package com.allen.spring.boot.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author first
 *
 */
public class TryConcurrency {

    public static void main(String[] args) throws InterruptedException {
//        new Thread("myThread") {
//            @Override
//            public void run() {
//                browseNews();
//            }
//        }.start();
//        System.out.println(Thread.currentThread().getName());
//        listenMusic();
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("Hello");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        };
        thread.start();
        TimeUnit.SECONDS.sleep(2);
        thread.start();
    }

    private static void browseNews() {
        for (;;) {
            System.out.println(Thread.currentThread().getName());
            System.out.println("The good news.");
            // The thread does not lose ownership of any monitors.
            sleep(1);
        }
    }

    private static void listenMusic() {
        for (;;) {
            System.out.println("The nice music.");
            sleep(1);
        }
    }

    private static void sleep(int i) {
        try {
            TimeUnit.MINUTES.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
