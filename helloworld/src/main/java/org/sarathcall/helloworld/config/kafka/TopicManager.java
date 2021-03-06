package org.sarathcall.helloworld.config.kafka;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.apache.kafka.clients.admin.NewTopic;
import org.sarathcall.helloworld.config.kafka.TopicList.Topic;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.web.context.support.GenericWebApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
@EnableKafka
public class TopicManager {
    private final TopicList topicList;
    private final GenericWebApplicationContext context;

    public TopicManager (
                        TopicList topicConfigs,
                        GenericWebApplicationContext aContext) {
                    log.trace ("--> Entering TopicManager Constructor");
                    if (topicConfigs == null) {
                        log.warn("==== there are no topics configured in application properties, creating a test topic");
                    }
                    this.topicList = topicConfigs;
                    // If there are no topics, create a test topic with the app name prefix. 
                    
                    this.context = aContext; 
                    log.debug ("===  Number of topics configured = {}",  topicConfigs.getTopics().get().size());
                    log.trace ("<-- Exiting TopicManager Constructor");
                    }

    @PostConstruct
    public void createTopics() {
        log.trace ("--> Entering CreateTopics");
        Optional<List<Topic>> topics = this.topicList.getTopics();
        topics.ifPresent(this::initTopicBeans);
        log.debug ("Initialized {} newTopicBeans", topics.map(List::size).orElse(0));
        log.trace ("<-- Exiting Creating Topics");
    }

    private  void initTopicBeans(List<Topic> topics) {
        log.trace ("--> Entering initTopicBeans");
        topics.forEach (aTopic -> {
            context.registerBean(aTopic.getName(), 
                                NewTopic.class, 
                                aTopic::toNewTopic);
        });
        log.trace ("<-- Returning from initTopicBeans");
    }
}

// TODO: When building the project, if kafka is not available, dont create these topics. 