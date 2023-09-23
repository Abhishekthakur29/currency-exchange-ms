package com.abhiTech.currencyConversionMS.currencyExchangeProxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.abhiTech.currencyConversionMS.bean.CurrencyConversionBean;


//@FeignClient(name = "currency-exchange-service", url = "localhost:8001")
@FeignClient(name = "currency-exchange-service")
public interface CurrencyExchangeProxy {
	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable String from, @PathVariable String to) ;
}