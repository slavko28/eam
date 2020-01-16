package com.demo.service.amazonSNS.impl;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.*;
import com.demo.service.amazonSNS.TopicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private AmazonSNS amazonSNS;

    @Override
    public List<String> getTopicList() {
        log.debug("Getting list of topics");
        return amazonSNS.listTopics().getTopics()
                .stream()
                .map(Topic::getTopicArn)
                .collect(Collectors.toList());
    }

    @Override
    public String createNewTopic(String name) {
        CreateTopicRequest createTopicRequest = new CreateTopicRequest().withName(name);
        CreateTopicResult createTopicResult = amazonSNS.createTopic(createTopicRequest);
        log.debug("Topic '{}' created. Topic ARN - {}", name, createTopicResult.getTopicArn());
        return createTopicResult.getTopicArn();
    }

    @Override
    public String removeTopic(String topicArm) {
        DeleteTopicRequest deleteTopicRequest = new DeleteTopicRequest().withTopicArn(topicArm);
        DeleteTopicResult deleteTopicResult = amazonSNS.deleteTopic(deleteTopicRequest);
        log.debug("Topic with ARN '{}' - has been successfully removed.", topicArm);
        return deleteTopicResult.toString();
    }

}
