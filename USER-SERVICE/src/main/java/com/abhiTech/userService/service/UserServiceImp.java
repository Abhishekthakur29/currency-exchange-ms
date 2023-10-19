package com.abhiTech.userService.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.abhiTech.userService.bean.UserBean;
import com.abhiTech.userService.exception.UserNotFoundException;
import com.abhiTech.userService.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

	Logger logger = LoggerFactory.getLogger(UserServiceImp.class);

	/**
	 * @author
	 * @param id
	 * @return HotelRatingBean
	 */
	public Optional<UserBean> commonfindbyId(String id) {
		Optional<UserBean> hotelRatingBeanOptional = userRepository.findById(id);
		if (hotelRatingBeanOptional.isEmpty()) {
			throw new UserNotFoundException("User Details not found with given id " + id, "404");
		}
		return hotelRatingBeanOptional;

	}

	@Override
	public List<UserBean> getAllUser() {

		List<UserBean> listOfUser = userRepository.findAll();
		return listOfUser;
	}

	@Override
	public UserBean createuser(UserBean user) {
		logger.info("User Details ::: " + user);
		user.setUserId(UUID.randomUUID().toString());
		UserBean userInfo = userRepository.save(user);
		return userInfo;
	}

	@Override
	public UserBean findByUserId(String id) {
		logger.info("USER ID :: " + id);
		UserBean userDetails = commonfindbyId(id).get();

		ArrayList hotelRating = restTemplate.getForObject(
				"http://localhost:8105/hotel-rating/api/get-hotel/rating", ArrayList.class);
		logger.info("Hotel rating Details :: {} ", hotelRating);
		userDetails.setUserRating(hotelRating);
		return userDetails;
	}

}
