package com.genband.debug;

import com.genband.util.broker.BrokerMessagingService;
import com.genband.util.broker.BrokerType;
import com.genband.util.broker.MessagingService;

public class DebugInstanceExample {

    public static void main(String args[]) {

        /*
         * Start message consumption
         */
        MessagingService svc = BrokerMessagingService.getService(BrokerType.RABBITMQ);

        /*
         * Optional step, once enable, microservice will start to share
         */
        svc.enableDebug();

        svc.startConsumeMessaging();

        // for(;;){
        // try {
        // Thread.sleep(3000);
        // System.out.println("Hello World!!!");
        // System.out.println("Hahaha the debug G: " + args);
        // } catch (InterruptedException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        //
        // }
    }

}
