package org.sarathcall.helloworld.services;

import org.sarathcall.helloworld.model.GreetingRequest;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String getGreeting (GreetingRequest aRequest) {
        return "Hello " + aRequest.getName() + ", Welcome here!!!!";
    }
}
