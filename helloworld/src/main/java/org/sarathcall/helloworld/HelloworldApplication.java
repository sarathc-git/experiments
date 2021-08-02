package org.sarathcall.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class HelloworldApplication {

	public static void main(String[] args) {
		log.info ("--> Starting HelloWorldApplication main");
		SpringApplication.run(HelloworldApplication.class, args);
		log.info ("<-- Exiting HelloWorldApplication main");
	}

}
