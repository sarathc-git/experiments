package org.sarathcall.helloworld.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloWorldControllerTest {

    @LocalServerPort 
    private int localPort; 
    
    @Autowired
    private TestRestTemplate client;
     
    @Test
    @Tag("e2e")
    public void testShouldReturnMessage() {
        String response = client.getForObject("http://localhost:" + localPort + "/v0.5/", String.class);
        assertEquals("Hello World", response);
    }

    
}
