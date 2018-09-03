/**
 * 
 */
package com.allen.spring.boot.thread.api;

/**
 * @author first
 *  MAX_PRIORITY = 10;MIN_PRIORITY = 1;
 *  
 */
public class ThreadPriority {

    
    public static void main(String[] args) {
        //Priority is higher,the probability of the CPU excuting is bigger. 
//        testPriority();
        
        // The priority of a thread does not exceed the priority of the thread group to which it belongs.
//        groupPriority();
        
        // The thread default priority inherit from parent thread.
        parentPriority();
    }
    
    public static void testPriority() {
        Thread t1 = new Thread(() -> {
            while(true) {
                System.out.println("The thread is t1.");
            }
        });
        t1.setPriority(3);
        
        Thread t2 = new Thread(() -> {
            while(true) {
                System.out.println("The thread is t2.");
            }
        });
        t2.setPriority(10);
        t1.start();
        t2.start();
    }
    
    public static void groupPriority() {
        ThreadGroup group = new ThreadGroup("testGroup");
        group.setMaxPriority(7);
        Thread t = new Thread(group , "myThread");
        t.setPriority(10);
        System.out.println(t.getPriority());
    }
    
    public static void parentPriority() {
        Thread t1 = new Thread();
        System.out.println("t1 priority is "+ t1.getPriority());
        //The thread id does not start from 0,beacause the jvm had started some thread when started.
//        System.out.println(t1.getId());
        Thread t2 = new Thread(() ->  {
            Thread t3 = new Thread();
            System.out.println("t3 priority is "+ t3.getPriority());
            
        });
        t2.setPriority(7);
        t2.start();
        System.out.println("t2 priority is "+ t2.getPriority());
    }
}
