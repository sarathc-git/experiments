package org.sarathcall.helloworld.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
     @RequestMapping("/v0.2/") 
     public String hello () {
         return "Hello World";
     }
}
