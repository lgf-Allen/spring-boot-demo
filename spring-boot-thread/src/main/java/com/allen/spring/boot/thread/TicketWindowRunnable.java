package com.allen.spring.boot.thread;

public class TicketWindowRunnable implements Runnable {

    
    private final String name;
    
    private static final int MAX = 50;
    private int index = 1;
    public TicketWindowRunnable(String name) {
      this.name = name;
    }
    @Override
    public void run() {
        while(index <= MAX) {
            System.out.println("柜员："+name+ ",当前号码："+(index++));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TicketWindowRunnable runnable = new TicketWindowRunnable("");
    }

}
