package com.demo.service.amazonSQS.impl;

import com.demo.service.amazonSQS.QueueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class QueueServiceImpl implements QueueService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @SqsListener("my_from_sns")
    public void messageHandler(String message, @Header("SenderId") String senderId) {
        log.info("received message from sender id:{}\nMessage:\n{}", senderId, message);
        kafkaTemplate.send("from_sqs", message);
    }

}
