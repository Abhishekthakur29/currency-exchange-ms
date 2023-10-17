package com.abhiTech.userService.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhiTech.userService.bean.UserBean;
import com.abhiTech.userService.service.UserServiceImp;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/")
public class UserServiceController {

	@Autowired
	private UserServiceImp userServiceImp;
	
	Logger logger = LoggerFactory.getLogger(UserServiceController.class);

	@GetMapping("/")
	public String welcomeMsg() {
		return "Welcome to the User microservice";
	}

	@PostMapping("create-user")
	public UserBean createuser(@Valid @RequestBody UserBean user) {
		return userServiceImp.createuser(user);
	}

	@GetMapping("user")
	public List<UserBean> getAlluser() {
		return userServiceImp.getAllUser();
	}

	@GetMapping("user/{id}")
	public UserBean finduserById(@PathVariable String id) {
		UserBean userDetails = userServiceImp.findByUserId(id);
		logger.info("USER DETAILS :: "+ userDetails);
		return userDetails;
				
	}
}
