package com.genband.debug.rabbitmq.service;

import com.genband.util.broker.model.Message;

public class RabbitmqMQhandler {

    private static RabbitmqMQhandler instance = null;
    private static Object mutex = new Object();

    public static RabbitmqMQhandler getInstance() {
        if (null == instance)
            synchronized (mutex) {
                if (null == instance)
                    instance = new RabbitmqMQhandler();
            }
        return instance;
    }

    public void handleRoutedMessage(Message message) {

    }

    public void handleUnroutedMessage(Message message) {

    }

}
