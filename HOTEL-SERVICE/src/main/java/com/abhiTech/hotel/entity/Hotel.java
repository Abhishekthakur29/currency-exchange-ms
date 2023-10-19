package com.abhiTech.hotel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Hotel {

	@Id
	private String hotel_id;
	private String hotel_Address;
	private String hotel_name;
	private String hotel_desc;
}
