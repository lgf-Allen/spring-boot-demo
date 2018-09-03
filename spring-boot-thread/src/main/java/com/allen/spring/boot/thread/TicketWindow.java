/**
 * 
 */
package com.allen.spring.boot.thread;

/**
 * @author first
 *
 */
public class TicketWindow extends Thread {

    
    private final String name;
    
    private static final int MAX = 50;
    private static int index = 1;
    public TicketWindow(String name) {
      this.name = name;
    }
    
    @Override
    public void run() {
       while(index <= MAX) {
           System.out.println("柜员："+name+ ",当前号码："+(index++));
       }
    }
    
    public static void main(String[] args) {
        TicketWindow ticketWindow1 = new TicketWindow("agent1");
        ticketWindow1.start();
        
        TicketWindow ticketWindow2 = new TicketWindow("agent2");
        ticketWindow2.start();
        
        TicketWindow ticketWindow3 = new TicketWindow("agent3");
        ticketWindow3.start();
        
        TicketWindow ticketWindow4 = new TicketWindow("agent4");
        ticketWindow4.start();
    }
    
}
