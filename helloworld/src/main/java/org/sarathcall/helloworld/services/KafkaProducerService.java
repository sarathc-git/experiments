package org.sarathcall.helloworld.services;

import org.sarathcall.helloworld.model.GreetingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaProducerService {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${app.greetingrequest.topic}")
    private String greetingRequestTopic;

    public void pushAGreetingRequest(GreetingRequest aRequest) {
        log.info("sending aRequest Object {}, to topic {}", aRequest, greetingRequestTopic);

        ListenableFuture<SendResult<String, Object>> future = this.kafkaTemplate.send(greetingRequestTopic, "",
                aRequest);
        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {

            @Override
            public void onSuccess(SendResult<String, Object> result) {
                log.info("Success in Posting to Kafka  {} ", aRequest);
            }

            @Override
            public void onFailure(Throwable ex) {
                log.error("Failure in posting to kafka ",ex);
            }
        });
    }
}