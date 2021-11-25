package com.etiya.rentACarSpring.business.dtos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.etiya.rentACarSpring.entities.Car;
import com.etiya.rentACarSpring.entities.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentalSearchListDto {

	private int rentalId;

	private int carId;

	private int userId;

	private Date rentDate;

	private Date returnDate;
}
