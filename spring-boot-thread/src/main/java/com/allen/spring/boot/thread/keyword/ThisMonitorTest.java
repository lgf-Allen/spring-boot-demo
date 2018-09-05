/**
 * 
 */
package com.allen.spring.boot.thread.keyword;

import java.util.concurrent.TimeUnit;

/**
 * @author first
 *   如图thisMonitor.png所示,实例同步方法持有的是相同的对象锁,只有当前一个方法释放后,下一个才可以获得对象锁。
 */
public class ThisMonitorTest {

    public synchronized void method1() {
        System.out.println(Thread.currentThread().getName() + " enter method1");
        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void method2() {
        System.out.println(Thread.currentThread().getName() + " enter method2");
        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        ThisMonitorTest monitor = new ThisMonitorTest();
        new Thread(monitor::method1).start();
        new Thread(monitor::method2).start();
    }

}
