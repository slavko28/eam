package com.demo.service.amazonSNS.impl;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import com.demo.service.amazonSNS.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private AmazonSNS amazonSNS;

    @Override
    public String publishMessage(String message, String topicArn) {
        PublishRequest publishRequest = new PublishRequest()
                .withMessage(message)
                .withTopicArn(topicArn);
        PublishResult publish = amazonSNS.publish(publishRequest);
        log.debug("Message id - {}", publish.getMessageId());
        return publish.getMessageId();
    }
}
