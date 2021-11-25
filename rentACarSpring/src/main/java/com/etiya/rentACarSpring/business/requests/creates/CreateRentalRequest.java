package com.etiya.rentACarSpring.business.requests.creates;

import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRentalRequest {

	//@NotNull
	//private int rentalId;
	
	@NotNull
	private int carId;
	
	@NotNull
	private int userId;
	
	@NotNull
	//@JsonFormat(pattern = "yyyy-MM-dd")
	//@DateTimeFormat(pattern="yyyy.MM.dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date rentDate;
	
	//@JsonFormat(pattern = "yyyy-MM-dd")
	//@DateTimeFormat(pattern="yyyy.MM.dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date returnDate;
}
