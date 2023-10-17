package com.abhiTech.userService.bean;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity(name = "User_Details")
public class UserBean {

	@Id
	private String userId;
	@NotBlank(message = "Username is required")
	private String userName;
	private String userEmail;
	@Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be a 10-digit number")
	private String userMobile;

	@Transient
	private List<Rating> userRating = new ArrayList<Rating>();

}
