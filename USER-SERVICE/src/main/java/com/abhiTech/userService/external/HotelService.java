package com.abhiTech.userService.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.abhiTech.userService.bean.Hotel;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

	@GetMapping("/api/hotel/get-hotel/{hotelId}")
	public Hotel getHotel(@PathVariable("hotelId") String hotelId);

}
