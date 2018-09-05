/**
 * 
 */
package com.allen.spring.boot.thread;

/**
 * @author first
 *
 */
public class ThreadOrder implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadOrder thread = new ThreadOrder();
        // subthread state is RUNABLE at now.
        new Thread(thread , "子线程对象").start();
        Thread.yield();
        thread.run();
    }
    
}
