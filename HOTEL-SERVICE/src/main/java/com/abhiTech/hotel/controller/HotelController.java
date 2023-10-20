package com.abhiTech.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhiTech.hotel.entity.Hotel;
import com.abhiTech.hotel.service.HotelService;

@RestController
@RequestMapping("api/hotel/")
public class HotelController {

	@Autowired
	private HotelService hotelService;

	@GetMapping("get-all")
	public List<Hotel> getAllHotel() {
		return hotelService.getAllHotel();
	}

	@PostMapping("create-new")
	public Hotel createnewHotel(@RequestBody Hotel hotel) {
		return hotelService.createHotel(hotel);
	}
	
	@GetMapping("get-hotel/{hotel_id}")
	public Hotel getHotelById(@PathVariable String hotel_id) {
		return hotelService.getHotelById(hotel_id);
	}
}
