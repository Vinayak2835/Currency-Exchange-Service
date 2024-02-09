package com.currencyexchangeservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {

	@GetMapping("/sample-api")

	@Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")

	//@CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
	public String sampleApI() {

		ResponseEntity<String> responseBody = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url",
				String.class);

		return responseBody.getBody();

	}

	public String hardCodedResponse(Exception ex) {
		return "hard-codedresponse";
	}

}
