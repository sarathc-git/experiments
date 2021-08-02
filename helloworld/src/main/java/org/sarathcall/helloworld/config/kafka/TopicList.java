package org.sarathcall.helloworld.config.kafka;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Validated
@Configuration
@ConfigurationProperties("app.kafka")
@Slf4j
public class TopicList {
    private List<Topic> topics; 
    
    public Optional<List<Topic>> getTopics (){ 
        log.trace ("---> Starting getTopics with topics {}", topics);
        
        log.trace ("<-- Returning from getTopics with topics {}", topics); 
        return Optional.ofNullable(topics);
    }

    // TODO : need to put validations for the Topic.
    @Data
    static class Topic {
        @NotNull (message = "Topic name is mandatory")
        private String name;
        private Integer numOfPartitions = 2;
        private Short replicationFactor = 1;

        NewTopic toNewTopic() {
            log.trace ("--> Inside toNewTopic, creating NewTopic object");
            log.debug ("Creating a NewTopic Object for topic {}, with {} partitions", this.name, this.numOfPartitions);
            log.trace ("--> Inside toNewTopic, creating NewTopic object");
            return new NewTopic(this.name, this.numOfPartitions, this.replicationFactor);
        }
    }
}
// TODO : Build a test case for this configuration class. 
