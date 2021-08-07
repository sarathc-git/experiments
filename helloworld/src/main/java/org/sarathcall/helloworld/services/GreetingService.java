package org.sarathcall.helloworld.services;

import com.github.ksuid.KsuidGenerator;

import org.sarathcall.helloworld.entities.aerospike.GreetingRequestEntity;
import org.sarathcall.helloworld.model.GreetingRequest;
import org.sarathcall.helloworld.repositories.aerospike.GreetingRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GreetingService {

    @Autowired
    GreetingRequestRepo greetingRequestRepo;
    // TODO: Need to extract and interface for the repo and some how
    // inject an aerospike repo now and may be make the actual repo injectable. 

    public String getGreeting (GreetingRequest aRequest) {
        log.trace ("--> Entering the getGreeting method");
        log.debug ("Getting Greeting for {}", aRequest.getName());

        String ksuid = KsuidGenerator.generate();
        
        GreetingRequestEntity grEntity = GreetingRequestEntity.builder()
                                                .uid(ksuid)
                                                .name(aRequest.getName())
                                                .locale(aRequest.getLocale())
                                                .build();
                                                
        greetingRequestRepo.save(grEntity);

        String response = "Hello " + aRequest.getName() + ", Welcome here!!!!";
        log.debug ("Responding with the response {}", response);
        log.trace ("<-- Exiting the getGreeting method");
        return response;
    }
}
