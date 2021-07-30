package org.sarathcall.helloworld.services;

import org.sarathcall.helloworld.model.GreetingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
     @Autowired 
     private KafkaTemplate<String, Object> kafkaTemplate;

    @Value ("${app.greetingrequest.topic}")
    private String greetingRequestTopic;
    
    public void pushAGreetingRequest (GreetingRequest aRequest) {
        this.kafkaTemplate.send(greetingRequestTopic, aRequest);
    }

}