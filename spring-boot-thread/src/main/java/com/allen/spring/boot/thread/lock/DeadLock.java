/**
 * 
 */
package com.allen.spring.boot.thread.lock;

/**
 * @author first
 *
 */
public class DeadLock {

    private final Object MUTEX_READ = new Object();
    private final Object MUTEX_WRITE = new Object();
    
    
    public void read() {
        synchronized (MUTEX_READ) {
            System.out.println(Thread.currentThread().getName() + " get READ lock.");
            synchronized (MUTEX_WRITE) {
                System.out.println(Thread.currentThread().getName() + " get WRITE lock.");
            }
            System.out.println(Thread.currentThread().getName() + " release WRITE lock.");
        }
        System.out.println(Thread.currentThread().getName() + " release READ lock.");
    }
    
    public void write() {
        synchronized (MUTEX_WRITE) {
            System.out.println(Thread.currentThread().getName() + " get WRITE lock.");
            synchronized (MUTEX_READ) {
                System.out.println(Thread.currentThread().getName() + " get READ lock.");
            }
            System.out.println(Thread.currentThread().getName() + " release READ lock.");
        }
        System.out.println(Thread.currentThread().getName() + " release WRITE lock.");
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        //jstack pid
        //一般的交叉锁引起的死锁线程都会进入BLOCKED状态,如图deadLock.png所示
        final DeadLock lock = new DeadLock();
        new Thread(() -> {
            while(true) {
                lock.read();
            }
        } , "READ_THREAD").start();
        
        new Thread(() -> {
            while(true) {
                lock.write();
            }
        } , "WRITE_THREAD").start();
    }

}
