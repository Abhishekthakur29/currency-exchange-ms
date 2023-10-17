package com.abhiTech.currencyConversionMS.circuitBreakerController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {
	
	private Logger logger= LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@Retry(name = "default")
	@GetMapping("sample-api")
	public String getcricuirtBreaker()	{
		logger.info("Sample api call received");
		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:9090", String.class);
		return forEntity.getBody();
	}
}
