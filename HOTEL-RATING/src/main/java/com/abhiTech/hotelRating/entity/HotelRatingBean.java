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
	private String id;
	private String hotelName;
	private String hotelAddress;
	private String hotelRating;
	private String hotelFeedback;
}
