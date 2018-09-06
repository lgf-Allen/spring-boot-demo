/**
 * 
 */
package com.allen.spring.boot.thread.keyword;

import java.util.concurrent.TimeUnit;

/**
 * @author meng
 *
 */
public class SynchronizedShortage {
	
	
	public synchronized void method() {
		try {
			TimeUnit.HOURS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {

		SynchronizedShortage syn = new SynchronizedShortage();
		Thread t1 = new Thread(syn::method , "t1");
		t1.start();
		TimeUnit.MICROSECONDS.sleep(10);
		Thread t2 = new Thread(syn::method , "t2");
		t2.start();
		TimeUnit.MILLISECONDS.sleep(2);
		t2.interrupt();
		System.out.println(t2.isInterrupted());
		System.out.println(t2.getState());
	}

}
