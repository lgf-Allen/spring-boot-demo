/**
 * 
 */
package com.allen.spring.boot.thread.lock;

import java.util.HashMap;

/**
 * @author first
 *
 */
public class HashMapDeadLock {

    private final HashMap<String ,String> map = new HashMap<String, String>();
    
    public void add(String key, String value) {
        map.put(key, value);
    }
    /**
     * @param args
     */
    public static void main(String[] args) {

        final HashMapDeadLock lock = new HashMapDeadLock();
        for(int i = 0;i < 2;i++) {
            new Thread(() -> {
                for(int x = 1; x < Integer.MAX_VALUE;x++) {
                    lock.add(String.valueOf(x), String.valueOf(x));
                }
            }).start();
        }
    }

}
