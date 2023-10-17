package com.abhiTech.hotelRating.HotelRatingService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhiTech.hotelRating.HotelRatingRepository.HotelRatingRepository;
import com.abhiTech.hotelRating.Utility.ExceptionCode;
import com.abhiTech.hotelRating.entity.HotelRatingBean;
import com.abhiTech.hotelRating.exception.DataNotFoundException;

@Service
public class HotelRatingServiceImpl implements HotelRatingService {

	@Autowired
	private HotelRatingRepository hotelRatingRepository;

	/**
	 * @author
	 * @param id
	 * @return HotelRatingBean
	 */
	public Optional<HotelRatingBean> commonfindbyId(String id) {
		Optional<HotelRatingBean> hotelRatingBeanOptional = hotelRatingRepository.findById(id);
		if (hotelRatingBeanOptional.isEmpty()) {
			throw new DataNotFoundException(ExceptionCode.USER_NOT_FOUND, "No data found with the respective Id");
		}
		return hotelRatingBeanOptional;

	}

//	@Override
	public List<HotelRatingBean> getHotelRating() {
		List<HotelRatingBean> list = hotelRatingRepository.findAll();
		return list;
	}

//	@Override
	public HotelRatingBean addHotelRating(HotelRatingBean hotelRatingBean) {
		HotelRatingBean save = hotelRatingRepository.save(hotelRatingBean);
		return save;
	}

	@Override
	public HotelRatingBean deleHotelRating(String id) {
		HotelRatingBean rating = commonfindbyId(id).get();
		hotelRatingRepository.delete(rating);
		return rating;
	}

	@Override
	public HotelRatingBean updateHotelRating(String id, HotelRatingBean hotelRatingBean) {
		HotelRatingBean rating = commonfindbyId(id).get();
		rating.setHotelAddress(hotelRatingBean.getHotelAddress());
		rating.setHotelName(hotelRatingBean.getHotelName());
		rating.setHotelRating(hotelRatingBean.getHotelRating());
		hotelRatingRepository.save(rating);
		return rating;
	}

	public HotelRatingBean getHotelRatingById(String id) {
		return commonfindbyId(id).get();
	}

}
