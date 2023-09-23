package com.abhiTech.currencyExchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.abhiTech.currencyExchange.bean.CurrencyExchange;
import com.abhiTech.currencyExchange.service.CurrencyExchangeService;

@RestController
public class AppController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private CurrencyExchangeService currencyExchangeService;

	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		
		CurrencyExchange currencyExchangeData = currencyExchangeService.getCurrencyExchangeRepo(from, to);
//		CurrencyExchange currencyExchange = new CurrencyExchange(1000l, from, to, BigDecimal.valueOf(50), port);
		return currencyExchangeData;

	}
}