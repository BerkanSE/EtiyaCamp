package com.etiya.rentACarSpring.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.rentACarSpring.business.absracts.CarService;
import com.etiya.rentACarSpring.business.dtos.CarSearchListDto;

import com.etiya.rentACarSpring.business.requests.CreateCarRequest;
import com.etiya.rentACarSpring.business.requests.DeleteCarRequest;
import com.etiya.rentACarSpring.business.requests.UpdateCarRequest;

import com.etiya.rentACarSpring.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACarSpring.core.utilities.results.DataResult;
import com.etiya.rentACarSpring.core.utilities.results.Result;
import com.etiya.rentACarSpring.core.utilities.results.SuccessDataResult;
import com.etiya.rentACarSpring.core.utilities.results.SuccessResult;
import com.etiya.rentACarSpring.dataAccess.abstracts.CarDao;
import com.etiya.rentACarSpring.entities.Car;

@Service
public class CarManager implements CarService {

	private CarDao carDao;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public CarManager(CarDao carDao, ModelMapperService modelMapperService) {
		this.carDao = carDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<CarSearchListDto>> getAll() {
		List<Car> result = this.carDao.findAll();
		
		//Veri tablosundaki veriyi ilgili dto'ya mapledik.
		List<CarSearchListDto> response = result.stream().map(car -> modelMapperService.forDto()
				.map(car, CarSearchListDto.class)).collect(Collectors.toList());
		
		return new SuccessDataResult<List<CarSearchListDto>>(response, "Araçlar listelendi.");
		
	}

	@Override
	public Result save(CreateCarRequest createCarRequest) {
		Car car = modelMapperService.forRequest().map(createCarRequest, Car.class);
		this.carDao.save(car);
		return new SuccessResult("Araç eklendi.");
	}

	@Override
	public Result update(UpdateCarRequest updateCarRequest) {
		Car car = modelMapperService.forRequest().map(updateCarRequest, Car.class);
		this.carDao.save(car);
		return new SuccessResult("Araç güncellendi.");
	}

	@Override
	public Result delete(DeleteCarRequest deleteCarRequest) {
		Car car = modelMapperService.forRequest().map(deleteCarRequest, Car.class);
		this.carDao.delete(car);
		return new SuccessResult("Araç silindi.");
	}

}
