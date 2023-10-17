package com.abhiTech.userService.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Rating {
	@Id
	private String ratingId;
	private String userId;
	private String hotelId;
	private Double rating;
	private String feedback;

}
