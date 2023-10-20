package com.abhiTech.userService.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity(name = "Hotel_details")
public class Hotel {
	@Id
	private String hotelId;
	private String hotel_name;
	private String hotel_Address;
	private String hotel_desc;
}
