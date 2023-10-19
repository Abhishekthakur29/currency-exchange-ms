package com.abhiTech.hotel.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhiTech.hotel.entity.Hotel;
import com.abhiTech.hotel.repository.HotelRepo;

@Service
public class HotelService {

	@Autowired
	private HotelRepo hotelRepo;
	
	public Hotel createHotel(Hotel hotel) {
		hotel.setHotel_id(UUID.randomUUID().toString());
		return hotelRepo.save(hotel);
	}
	
	public List<Hotel> getAllHotel() {
		return hotelRepo.findAll();
	}
}
