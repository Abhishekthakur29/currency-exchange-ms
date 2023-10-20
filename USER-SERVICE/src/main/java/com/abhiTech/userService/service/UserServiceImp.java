package com.abhiTech.userService.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.abhiTech.userService.bean.Hotel;
import com.abhiTech.userService.bean.Rating;
import com.abhiTech.userService.bean.UserBean;
import com.abhiTech.userService.exception.UserNotFoundException;
import com.abhiTech.userService.external.HotelService;
import com.abhiTech.userService.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HotelService hotelService;

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

		Rating[] hotelRating = restTemplate.getForObject("http://HOTEL-RATING/hotel-rating/api/get-hotel/rating/" + id,
				Rating[].class);

		List<Rating> ratings = Arrays.stream(hotelRating).toList();
		logger.info("Hotel rating Details :: {} ", ratings);

		ArrayList<Rating> ratingList = (ArrayList<Rating>) ratings.stream().map(rating -> {
//			ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/api/hotel/get-hotel/"+rating.getHotelId() , Hotel.class);
//			Hotel hotel = forEntity.getBody();
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
			rating.setHotel(hotel);
			return rating;
		}).collect(Collectors.toList());
		userDetails.setUserRating(ratings);
		return userDetails;
	}

}
