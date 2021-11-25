package com.etiya.rentACarSpring.business.requests.updates;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.etiya.rentACarSpring.business.requests.creates.CreateBrandRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {

	@NotNull
	private int userId;
	
	@NotNull
	@Email
	private String email;
	
	@NotNull
	private String password;
	
}
