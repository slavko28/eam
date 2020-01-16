package com.demo.service.amazonSNS;

import java.util.List;

public interface TopicService {

    List<String> getTopicList();

    String createNewTopic(String name);

    String removeTopic(String topicArm);

}
