package com.abhiTech.limitservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhiTech.limitservice.ConfigApp.ConfigLimits;
import com.abhiTech.limitservice.bean.Limits;

@RestController
public class AppController {

	@Autowired
	private ConfigLimits configLimits;

	@GetMapping("get-limits")
	public Limits getLimits() {
		return new Limits(configLimits.getMaximum(), configLimits.getMinimum());
//		return new Limits(12, 1209);
	}
}
