package com.etiya.rentACarSpring.business.requests.deletes;

import javax.validation.constraints.NotNull;

import com.etiya.rentACarSpring.business.requests.creates.CreateBrandRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteRentalRequest {

	@NotNull
	private int rentalId;
	
}
