package com.etiya.rentACarSpring.business.requests.updates;

import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.etiya.rentACarSpring.business.requests.creates.CreateBrandRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateIndividualCustomerRequest {

	@NotNull
	private int individualCustomerId;
	
	@NotNull
	private int userId;

	@NotNull
	@Size(min=2, max=50)
	private String firstName;

	@NotNull
	@Size(min=2, max=50)
	private String lastName;

	@NotNull
	//@DateTimeFormat(pattern="yyyy.MM.dd")
	private LocalDate birthday;
}
