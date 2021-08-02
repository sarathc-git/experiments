package org.sarathcall.helloworld.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
class HelloWorldController {
    @RequestMapping("/v0.5/")
    public String hello() {
        log.info("--> Starting Request Processing");

        log.info("<-- Completed Request Processing");
        return "Hello World";
    }
}

// TODO: Ideally if we can create these traces through a filter or interceptor
///     The code would be cleaner. 