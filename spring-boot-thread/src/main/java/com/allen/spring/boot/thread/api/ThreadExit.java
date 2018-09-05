/**
 * 
 */
package com.allen.spring.boot.thread.api;

import java.util.concurrent.TimeUnit;

/**
 * catch interupt signal to close thread.
 * 
 * @author first
 *
 */
public class ThreadExit {

    public static void main(String[] args) throws InterruptedException {

        method1();
//        method2();
    }

    public static void method1() throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                super.run();
                System.out.println("I will start work.");
                //Waiting interrupted signal to shutdown thread.
                while (!isInterrupted()) {
                    System.out.println("working.");//When no interrupted signal executing.
                }
                System.out.println("I will be exiting.");
            }
        };
        t.start();
        TimeUnit.SECONDS.sleep(10);//block 10 seconds.
        System.out.println("System will be shutdown.");
        t.interrupt();
    }
    
    public static void method2() throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                super.run();
                System.out.println("I will start work.");
                for(; ;) {
                    System.out.println("I am working.");
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        System.out.println("break");
                        break;
                    }
                }
                System.out.println("I will be exiting.");
            }
        };
        t.start();
        TimeUnit.SECONDS.sleep(10);
        System.out.println("System will be shutdown.");
        t.interrupt();
    }

}
