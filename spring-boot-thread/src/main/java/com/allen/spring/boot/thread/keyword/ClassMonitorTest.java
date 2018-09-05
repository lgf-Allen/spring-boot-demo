/**
 * 
 */
package com.allen.spring.boot.thread.keyword;

import java.util.concurrent.TimeUnit;

/**
 * @author first
 *         如图classMonitor.png所示,静态同步方法持有的是相同的Class,只有当前一个方法释放后,下一个才可以获得Class锁。
 */
public class ClassMonitorTest {

    public static synchronized void method1() {
        System.out.println(Thread.currentThread().getName() + "enter method1");
        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void method2() {
        System.out.println(Thread.currentThread().getName() + "enter method2");
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
        new Thread(ClassMonitorTest::method1).start();
        new Thread(ClassMonitorTest::method2).start();
    }

}
