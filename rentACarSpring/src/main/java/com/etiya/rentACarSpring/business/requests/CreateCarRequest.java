package com.etiya.rentACarSpring.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {
	//Veritabanı id otomatik ekliyor, O yüzden Id eklemeyiz.
	
	private int brandId;
	
	private int colorId;

	private int modelYear;

	private int dailyPrice;
	
	private String description;
}
