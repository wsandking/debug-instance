package com.genband.debug;

public class PrintHelloWorldForever {

    public static void main(String args[]) {
        for(;;){
            try {
                Thread.sleep(3000);
                System.out.println("Hello World!!!");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
    }

}