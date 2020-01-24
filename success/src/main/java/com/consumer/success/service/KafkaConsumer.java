package com.consumer.success.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "from_sqs")
    public void messageListener(String message) {
        log.info("Received message: {}", message);
    }
}
