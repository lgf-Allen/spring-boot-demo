/**
 * 
 */
package com.allen.spring.boot.thread.api;

import java.util.stream.IntStream;

/**
 * @author meng
 *
 */
public class ThreadYield {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IntStream.range(0, 2).mapToObj(ThreadYield::create).forEach(Thread::start);
	}
	private static Thread create(int index) {
		return new Thread(() ->  {
			if(index == 0) {
				Thread.yield();
			}
			System.out.println(index);
		});
	}

}
