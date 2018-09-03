/**
 * 
 */
package com.allen.spring.boot.thread.api;

import java.util.concurrent.TimeUnit;

/**
 * @author meng
 *
 */
public class ThreadSleep {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		new Thread(() -> {
			long startTime = System.currentTimeMillis();
			sleep(2L);
			long endTime = System.currentTimeMillis();
			System.out.println(String.format("Total spend %d ms", (endTime - startTime)));
			
		}).start();
		
		long startTime =  System.currentTimeMillis();
		sleep(3L);
		long endTime = System.currentTimeMillis();
		System.out.println(String.format("Main thread total spend %d ms", (endTime - startTime)));
	}

	private static void sleep(long l) {

		try {
//			Thread.sleep(l);
			TimeUnit.SECONDS.sleep(l);
		}catch(InterruptedException e) {
			
		}
	}
	
		

}
