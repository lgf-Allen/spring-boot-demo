/**
 * 
 */
package com.allen.spring.boot.thread;

/**
 * @author meng
 *
 */
public class ThreadConstruction {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		if(args.length<1) {
//			System.out.println("Please enter the stack size:");
//			System.exit(1);
//		}
		ThreadGroup group = new ThreadGroup("TestGroup");
		Runnable runnable = new Runnable() {
			final int MAX = Integer.MAX_VALUE;
			@Override
			public void run() {
				int i = 0;
				recurse(i);
				
			}
			 int j = 1;
			private void recurse(int i) {
				try {
					System.out.println(i);
					if(i < MAX) {
						j = j+ 1;
						recurse(i);
					}
				}catch(Exception e) {
					System.out.println(j);
				}
				
			}
		};
		Thread thread = new Thread(group , runnable , "Test" , 10000);
		thread.start();
	}

}
