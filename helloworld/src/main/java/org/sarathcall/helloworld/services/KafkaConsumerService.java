package org.sarathcall.helloworld.services;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.sarathcall.helloworld.model.GreetingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaConsumerService {
   
    @Value("${app.greetingrequest.topic}")
    private String greetingRequestTopic;
    private final ObjectMapper objectMapper;

    @Autowired
    KafkaConsumerService(ObjectMapper objectMapper) {
        log.debug ("--> Entering the KafkaConsumerService Constructor");
        this.objectMapper = objectMapper;
        log.error ("====___________________________________________====");
        log.debug ("<-- Exiting the KafkaConsumerService Constructor");
    }

    @KafkaListener(topics = "${app.greetingrequest.topic}", 
                    groupId="greeting_consumer")
    public void process(ConsumerRecord <String, Object> aRecord) {
        log.error ("--> Entering the process method of the consumer");
        log.warn ("==== Received on object at offset: {}, on partition: {} : of topic {}", 
                    aRecord.offset(),   aRecord.partition(), aRecord.topic());
        
        GreetingRequest aRequest = (GreetingRequest) aRecord.value();
        log.error ("-------------------------------------------");
        log.warn ("The record recieved is {} ", aRequest);
        log.error ("+++++++++" + aRequest.getName());
        log.error ("Processing record {}", aRequest);
        log.warn ("Recieved an object {} in the consumer", aRequest);
        log.warn ("<-- Exiting the process method of the consumer");
    }
}