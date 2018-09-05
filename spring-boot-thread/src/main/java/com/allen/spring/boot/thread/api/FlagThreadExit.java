/**
 * 
 */
package com.allen.spring.boot.thread.api;

import java.util.concurrent.TimeUnit;

/**
 * @author first
 * 
 */
public class FlagThreadExit {

    static class MyTask extends Thread {

        // Sometimes , thread interupted signal may be erease ,so we add a volatile
        // flag.
        private volatile boolean closed = false;

        @Override
        public void run() {
            System.out.println("I will start work.");
            while (!closed && !isInterrupted()) {
                System.out.println("I am working.");
            }
            System.out.println("I will exiting.");
        }

        public void close() {
            this.closed = true;
            this.interrupt();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyTask t = new MyTask();
        t.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("System will be shutdown.");
        t.close();
    }
}
