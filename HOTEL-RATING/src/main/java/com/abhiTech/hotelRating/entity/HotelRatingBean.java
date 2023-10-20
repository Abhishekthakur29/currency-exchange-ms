package com.abhiTech.hotelRating.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Builder
@Document(collection = "Hotel_Rating")
public class HotelRatingBean {
	@Id
	private String ratingId;
	private String hotelId;
	private String userId;
	private double rating;
	private String hotelFeedback;
}
