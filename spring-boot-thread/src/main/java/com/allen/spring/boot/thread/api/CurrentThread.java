package com.allen.spring.boot.thread.api;

public class CurrentThread {

    public static void main(String[] args) {
        Thread thread = new Thread() {
          @Override
            public void run() {
              System.out.println(Thread.currentThread() == this);
            }  
        };
        thread.start();
        System.out.println("The thread name is "+ thread.getName());
        String name = Thread.currentThread().getName();
        System.out.println("main".equals(name));
    }

}
