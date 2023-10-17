package com.abhiTech.hotelRating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhiTech.hotelRating.HotelRatingService.HotelRatingServiceImpl;
import com.abhiTech.hotelRating.entity.HotelRatingBean;

@RestController
@RequestMapping("hotel-rating/api/")
public class HotelRatingController {

	@Autowired
	private HotelRatingServiceImpl hotelRatingServiceImpl;
	
	@GetMapping("welcome")
	public String getMsg() {
		return "Welcome to Spring ms";
	}

	@GetMapping("get-hotel/rating")
	public List<HotelRatingBean> getHotelRating() {
		return hotelRatingServiceImpl.getHotelRating();
	}

	@GetMapping("get-hotel/rating/{id}")
	public HotelRatingBean getratingById(@PathVariable String id) {
		return hotelRatingServiceImpl.getHotelRatingById(id);
	}

	@PostMapping("create-rating")
	public HotelRatingBean createRating(@RequestBody HotelRatingBean hotelRatingBean) {
		return hotelRatingServiceImpl.addHotelRating(hotelRatingBean);
	}

	@PutMapping("update-rating/{id}")
	public HotelRatingBean updateRating(@RequestBody HotelRatingBean hotelRatingBean, @PathVariable String id) {
		return hotelRatingServiceImpl.updateHotelRating(id, hotelRatingBean);
	}
	
	@DeleteMapping("delete-rating/{id}")
	public HotelRatingBean deleteRating(@PathVariable String id) {
		return hotelRatingServiceImpl.deleHotelRating(id);
	}

}
