/**
 * 
 */
package com.allen.spring.boot.thread;

/**
 * @author first
 *
 */
public class TemplateMethod {

    /**
     * @param args
     */
    public static void main(String[] args) {
        TemplateMethod template = new TemplateMethod() {
            @Override
            protected void wrapPrint(String message) {
                System.out.println(message);
            }
        };
        template.print("Hello template");
    }
    
    public final void print(String message) {
        System.out.println("***********************");
        wrapPrint(message);
        System.out.println("***********************");
    }

    protected void wrapPrint(String message) {
       
        
    }

}
