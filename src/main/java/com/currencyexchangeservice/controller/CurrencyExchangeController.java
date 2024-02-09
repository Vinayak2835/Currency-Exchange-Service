package com.currencyexchangeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.currencyexchangeservice.model.ExchangeValue;
import com.currencyexchangeservice.repository.ExchangeValueRepository;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment environment;

	@Autowired
	private ExchangeValueRepository exchangeValueRepository;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable("from") String from,@PathVariable("to") String to) {

		//http://localhost:8081/currency-exchange/from/AUD/to/INR
		
	    ExchangeValue exchangeValue = this.exchangeValueRepository.findByFromAndTo(from, to);
	 //   System.out.println(exchangeValue.toString());

	   // exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
	    
	    String port = environment.getProperty("local.server.port");
	    exchangeValue.setEnvironment(port);
	     
	    return exchangeValue;
	
	}

}
