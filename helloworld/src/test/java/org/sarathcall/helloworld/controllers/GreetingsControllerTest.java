package org.sarathcall.helloworld.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Locale;

import com.github.javafaker.Faker;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.sarathcall.helloworld.model.GreetingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GreetingsControllerTest {

    @LocalServerPort 
    private int localPort; 
    
    @Autowired
    private TestRestTemplate client;
     
    @Test
    @Tag("e2e")
    public void testShouldReturnMessage() {
        String response = client.getForObject("http://localhost:" + localPort + "/v0.1/", String.class);
        assertEquals("Hello from Greeting Request", response);
    }

    // TODO : Move the faker to a setup method. 

    @Test
    @Tag("e2e")
    public void testPostAGreetingRequest () {   
        String url = "http://localhost:" + localPort + "/v0.1/GreetingRequest";
        HttpHeaders headers = new HttpHeaders();
        headers.add ("Content-Type", "application/json");
        headers.add ("Accept", "text/plain");
        
        Faker faker = new Faker(new Locale("en-in"));

        String name = faker.name().firstName();
        GreetingRequest reqBody = GreetingRequest.builder()
                                                    .name(name)
                                                    .locale("en-in")
                                                    .build();

        String response = client.postForObject (url, reqBody, String.class);
        assertEquals("Hello " + name+ ", Welcome here!!!!", response);
    }

    
}
