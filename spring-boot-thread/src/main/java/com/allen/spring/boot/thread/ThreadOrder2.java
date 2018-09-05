/**
 * 
 */
package com.allen.spring.boot.thread;

/**
 * @author first
 *
 */
public class ThreadOrder2 extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
    
    public static void main(String[] args) {
        ThreadOrder2 order = new ThreadOrder2();
        Thread thread = new Thread(() -> {
            System.out.println("subTread name is "+Thread.currentThread().getName());
        },"subThread");
        thread.start();
        order.run();
    }
}
