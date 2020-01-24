package com.demo.controller;

import com.demo.model.Message;
import com.demo.service.amazonSNS.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SnsMessageController {

    @Autowired
    private MessageService messageService;

    @PutMapping(value = "/publish")
    public String publishMessage(@RequestBody Message message) {
        log.debug("\nReceive request to publish new message:\n {}\n into the topic: {}", message.getMessage(), message.getTopicArn());
        return messageService.publishMessage(message.getMessage(), message.getTopicArn());
    }
}
