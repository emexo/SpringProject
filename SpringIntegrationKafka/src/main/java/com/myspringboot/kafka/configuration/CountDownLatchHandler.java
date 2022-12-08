package com.myspringboot.kafka.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

import java.util.concurrent.CountDownLatch;

@Slf4j
public class CountDownLatchHandler implements MessageHandler {
    private CountDownLatch latch = new CountDownLatch(10);

    public CountDownLatch getLatch() {
        return latch;
    }

    @Override
    public void handleMessage(Message<?> message) throws MessagingException {
        log.info("received message='{}'", message);
        latch.countDown();
    }
}
