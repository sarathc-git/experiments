package org.sarathcall.helloworld.services;

import org.sarathcall.helloworld.model.GreetingRequest;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GreetingService {
    public String getGreeting (GreetingRequest aRequest) {
        log.trace ("--> Entering the getGreeting method");
        log.debug ("Getting Greeting for {}", aRequest.getName());
        String response = "Hello " + aRequest.getName() + ", Welcome here!!!!";
        log.debug ("Responding with the response {}", response);
        log.trace ("<-- Exiting the getGreeting method");
        return response;
    }
}
