package com.genband.debug.rabbitmq;

import com.genband.debug.rabbitmq.service.RabbitmqMQhandler;
import com.genband.util.broker.model.Message;
import com.genband.util.broker.model.OperationReceipt;
import com.genband.util.broker.rabbitmq.annotation.RabbitmqMessageController;
import com.genband.util.broker.rabbitmq.annotation.RabbitmqMessageHandler;
import com.genband.util.broker.rabbitmq.annotation.RabbitmqMessageHandlerConstructor;
import com.genband.util.log.slf4j.GbLogger;
import com.genband.util.log.slf4j.GbLoggerFactory;

@RabbitmqMessageController
public class RabbitmqHandler {

    private static GbLogger log = GbLoggerFactory.getGbLogger(RabbitmqHandler.class.getName());

    private RabbitmqMQhandler handler;
    private Object mutex = new Object();
    private int messageCount;

    @RabbitmqMessageHandlerConstructor(instanceType = "singleton", springbootEnabled = false, invokeProp = false)
    public RabbitmqHandler() {
        /*
         * Handler your initialzation for handler here
         */
        handler = RabbitmqMQhandler.getInstance();
        messageCount = 0;
        log.debug("Let me know if you have seen this.");
    }

    @RabbitmqMessageHandler(listenChannel = "self")
    public OperationReceipt handleMessage(Message message, String routingKey) {
        OperationReceipt receipt = new OperationReceipt();
        /*
         * Handler your routed message here!
         */
        synchronized (mutex) {
            messageCount++;
        }

        log.info(String.format("Receive message : %s with routing key: %s, \n Message Count: %d", message, routingKey,
                messageCount));
        handler.handleRoutedMessage(message);

        // Set operation status based on actual execution
        receipt.setOperationStatus(true);
        return receipt;
    }

    @RabbitmqMessageHandler(listenChannel = "unallocated")
    public OperationReceipt handleNewCommingMessage(Message message, String routingKey) {
        OperationReceipt receipt = new OperationReceipt();

        synchronized (mutex) {
            messageCount++;
        }
        log.info(String.format("Receive unrouted message : %s with routing key: %s, \n Message Count: %d", message,
                routingKey, messageCount));

        handler.handleUnroutedMessage(message);

        receipt.setOperationStatus(true);
        return receipt;
    }
}
