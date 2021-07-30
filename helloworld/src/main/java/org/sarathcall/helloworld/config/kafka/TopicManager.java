package org.sarathcall.helloworld.config.kafka;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.apache.kafka.clients.admin.NewTopic;
import org.sarathcall.helloworld.config.kafka.TopicList.Topic;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.GenericWebApplicationContext;

@Configuration
public class TopicManager {
    private final TopicList topicList;
    private final GenericWebApplicationContext context;

    public TopicManager (
                        TopicList topicConfigs,
                        GenericWebApplicationContext aContext) {
                    System.out.println ("==== Inside TopicManager");
                    this.topicList = topicConfigs;
                    this.context = aContext; 
                    System.out.println ("==== Number of topics = " + topicConfigs.getTopics().get().size());
                    }


    @PostConstruct
    public void createTopics() {
        System.out.println ("===== Creating topics");
        Optional<List<Topic>> topics = this.topicList.getTopics();
        topics.ifPresent(this::initTopicBeans);
        
    }

    private  void initTopicBeans(List<Topic> topics) {
        System.out.println ("=== Inside initTopicBeans");
        topics.forEach (aTopic -> {
            context.registerBean(aTopic.getName(), 
                                NewTopic.class, 
                                aTopic::toNewTopic);
        });
    }
}
