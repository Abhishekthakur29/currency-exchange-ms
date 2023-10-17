package com.abhiTech.hotelRating.HotelRatingService;

import java.util.List;

import com.abhiTech.hotelRating.entity.HotelRatingBean;

public interface HotelRatingService {

	public List<HotelRatingBean> getHotelRating();

	public HotelRatingBean addHotelRating(HotelRatingBean hotelRatingBean);

	public HotelRatingBean deleHotelRating(String id);

	public HotelRatingBean updateHotelRating(String id, HotelRatingBean hotelRatingBean);

}
