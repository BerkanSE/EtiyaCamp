package com.etiya.rentACarSpring.business.dtos;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSearchListDto {

	private int id;

	private String email;

}
