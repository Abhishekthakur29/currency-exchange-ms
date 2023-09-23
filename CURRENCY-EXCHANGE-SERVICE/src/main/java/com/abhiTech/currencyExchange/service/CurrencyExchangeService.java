package com.abhiTech.currencyExchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhiTech.currencyExchange.bean.CurrencyExchange;
import com.abhiTech.currencyExchange.exception.NoSuchDataFound;
import com.abhiTech.currencyExchange.repostory.CurrencyExchangeRepo;

@Service
public class CurrencyExchangeService {

	@Autowired
	private CurrencyExchangeRepo currencyExchangeRepo;
	
	@Autowired
	public org.springframework.core.env.Environment environment;

	public CurrencyExchange getCurrencyExchangeRepo(String from, String to) {
		String port = environment.getProperty("local.server.port");
		CurrencyExchange exchangeRepo = currencyExchangeRepo.findByfromAndTo(from, to);
		if (exchangeRepo == null) {
			throw new NoSuchDataFound("Not Data Found ", "404");
		}else {
			exchangeRepo.setEnvironment(port);
		}
		return exchangeRepo;
	}

}