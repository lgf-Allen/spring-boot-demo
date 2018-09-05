/**
 * 
 */
package com.allen.spring.boot.thread.keyword;

import java.util.concurrent.TimeUnit;

/**
 * @author first
 *
 */
public class SynchronizedTest {

    private final static Object MUTEX = new Object();
    
    public void accessResource() {
        synchronized(MUTEX) {
            try {
                TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        final SynchronizedTest sys = new SynchronizedTest();
        for(int i = 0;i < 5;i++) {
            new Thread(sys::accessResource).start();
        }
    }
}
