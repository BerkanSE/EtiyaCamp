package com.etiya.rentACarSpring.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.etiya.rentACarSpring.business.dtos.RentalSearchListDto;
import com.etiya.rentACarSpring.entities.Rental;

public interface RentalDao extends JpaRepository<Rental, Integer>{
	
	List<Rental> getByCar_Id(int carId);
	
	@Query("Select new com.etiya.rentACarSpring.business.dtos.RentalSearchListDto"
            + "(r.rentalId, c.id, r.rentDate, r.returnDate) " 
            +     "From Car c Inner Join c.rentals r where c.id=:carId and r.returnDate is null")
    RentalSearchListDto getByCarIdWhereReturnDateIsNull(int carId);
	
}
