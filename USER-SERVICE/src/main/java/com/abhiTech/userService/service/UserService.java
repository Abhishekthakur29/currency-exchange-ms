package com.abhiTech.userService.service;

import java.util.List;

import com.abhiTech.userService.bean.UserBean;

public interface UserService {

	public List<UserBean> getAllUser();

	public UserBean createuser(UserBean user);
	
	public UserBean findByUserId(String id);
}
