package org.sarathcall.helloworld.controllers;

import org.sarathcall.helloworld.dtos.GreetingRequestDTO;
import org.sarathcall.helloworld.model.GreetingRequest;
import org.sarathcall.helloworld.services.GreetingService;
import org.sarathcall.helloworld.services.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping ("/v0.1")
@Slf4j
public class GreetingsController {

    @Autowired
    GreetingService service;

    @Autowired
    KafkaProducerService aKafkaProducer; 
 /**
  * Provides clients a POST API for a GreetingRequest.
  * 
  * @param aRequest
  * @return aGreeting
  */
    @PostMapping(value = "/GreetingRequest", 
    consumes = "application/json",
    produces = "text/plain") 
    public String getGreeting (@RequestBody GreetingRequestDTO aRequestDTO
                                ,@RequestHeader(name = "Content-Type") String contentType) {
        log.trace ("--> Starting Request Processing");
        GreetingRequest aRequest = GreetingRequest
                                    .builder()
                                    .name(aRequestDTO.getName())
                                    .locale(aRequestDTO.getLocale())
                                    .build();
                                    
        log.debug ("Content Type : {}", contentType);
        log.debug ("DTO : {}", aRequestDTO);
        log.debug ("Model : {} ", aRequest);

        String response = service.getGreeting(aRequest);
        
        aKafkaProducer.pushAGreetingRequest(aRequest);
        log.debug("Published {} to kafka", aRequest);
        
        log.trace("<-- Completed Request Processing");
        return response;
    }

    @GetMapping(value="/")
    public String defaultResponder () {
        log.info("--> Started Request Processing");
        log.info("<-- Completed Request Processing");
        return "Hello from Greeting Request";
        

    }

}
/**
 * DONE: Create a simple POST Handler.
 * TODO: Add ModelMapper / MapStruct.
 * TODO: Add Loggers
 * TODO: Build the logger to create a trace before and after the request. 
 * TODO: Add authentication and security
 * TODO: Setup some validations for the name
 * TODO: Setup a Kafka pipeline to push the name submissions.
 * TODO: Setup a Grafana business dashboard with some metrics. 
 * TODO: Enable preconfigured dahsboards for the project. 
 * TODO : Figure out other ways to setup the version of the api. 
 * TODO : Enable versioning based on accept headers and client version.
*/