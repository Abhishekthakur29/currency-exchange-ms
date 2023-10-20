package com.abhiTech.hotelRating.HotelRatingRepository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.abhiTech.hotelRating.entity.HotelRatingBean;

@Repository
public interface HotelRatingRepository extends MongoRepository<HotelRatingBean, String> {
	
	List<HotelRatingBean> findByUserId(String userId);	
}
