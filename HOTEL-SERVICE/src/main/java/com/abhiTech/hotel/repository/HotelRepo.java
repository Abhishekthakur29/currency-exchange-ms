package com.abhiTech.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.abhiTech.hotel.entity.Hotel;


@Repository
public interface HotelRepo extends JpaRepository<Hotel, String>{
	
	@Procedure(name = "GetUsers")
    List<Hotel> callGetUsersProcedure();
	

}
