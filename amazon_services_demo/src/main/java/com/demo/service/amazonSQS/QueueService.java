package com.demo.service.amazonSQS;

import org.springframework.messaging.handler.annotation.Header;

public interface QueueService {

    void messageHandler(String message, @Header("SenderId") String senderId);

}
