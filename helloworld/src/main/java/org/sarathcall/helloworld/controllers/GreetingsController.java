package org.sarathcall.helloworld.controllers;

import org.sarathcall.helloworld.dtos.GreetingRequestDTO;
import org.sarathcall.helloworld.model.GreetingRequest;
import org.sarathcall.helloworld.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/v0.1")
public class GreetingsController {

    @Autowired
    GreetingService service;
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
        GreetingRequest aRequest = GreetingRequest
                                    .builder()
                                    .name(aRequestDTO.getName())
                                    .locale(aRequestDTO.getLocale())
                                    .build();
        System.out.println ("Content Type : "  + contentType);
        System.out.println ("DTO : " + aRequestDTO);
        System.out.println ("Model : " + aRequest);
        String response = service.getGreeting(aRequest);

        return response;
    }

    @GetMapping(value="/")
    public String defaultResponder () {
        return "Hello from Greeting Request";
    }

}
/**
 * DONE: Create a simple POST Handler.
 * TODO: Add ModelMapper / MapStruct.
 * TODO: Add Loggers
 * TODO: Setup some validations for the name. 
 * TODO: Setup a Kafka pipeline to push the name submissions.
 * TODO: Setup a Grafana business dashboard with some metrics. 
 * TODO: Enable preconfigured dahsboards for the project. 
 * TODO : Figure out other ways to setup the version of the api. 
 * TODO : Enable versioning based on accept headers and client version.
*/