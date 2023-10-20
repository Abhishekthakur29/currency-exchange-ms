package com.abhiTech.userService.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Rating {
	private String ratingId;
	private String hotelId;
	private String userId;
	private double rating;
	private String hotelFeedback;
	private Hotel hotel;

}
