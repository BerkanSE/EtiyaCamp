package com.etiya.RentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.RentACar.business.abstracts.CarService;
import com.etiya.RentACar.business.abstracts.MaintenanceService;
import com.etiya.RentACar.business.abstracts.RentalService;
import com.etiya.RentACar.business.abstracts.UserService;
import com.etiya.RentACar.business.dtos.CarSearchListDto;
import com.etiya.RentACar.business.dtos.MaintenanceDto;
import com.etiya.RentACar.business.dtos.RentalSearchListDto;
import com.etiya.RentACar.business.requests.Rental.CreateRentalRequest;
import com.etiya.RentACar.business.requests.Rental.DeleteRentalRequest;
import com.etiya.RentACar.business.requests.Rental.UpdateRentalRequest;
import com.etiya.RentACar.core.utilities.business.BusinessRules;
import com.etiya.RentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.RentACar.core.utilities.results.DataResult;
import com.etiya.RentACar.core.utilities.results.ErrorResult;
import com.etiya.RentACar.core.utilities.results.Result;
import com.etiya.RentACar.core.utilities.results.SuccessDataResult;
import com.etiya.RentACar.core.utilities.results.SuccessResult;
import com.etiya.RentACar.dataAccess.abstracts.RentalDao;
import com.etiya.RentACar.entites.Car;
import com.etiya.RentACar.entites.IndividualCustomer;
import com.etiya.RentACar.entites.Maintenance;
import com.etiya.RentACar.entites.Rental;
import com.etiya.RentACar.entites.ComplexTypes.RentalDetail;

@Service
public class RentalManager implements RentalService {

	private RentalDao rentalDao;
	private ModelMapperService modelMapperService;
	private CarService carService;
	private UserService userService;

	@Autowired
	private RentalManager(RentalDao rentalDao, ModelMapperService modelMapperService,CarService carService,UserService userService) {
		super();
		this.rentalDao = rentalDao;
		this.modelMapperService = modelMapperService;
		this.carService = carService;
		this.userService = userService;
	}

	@Override
	public DataResult<List<RentalSearchListDto>> getAll() {
		List<Rental> result = this.rentalDao.findAll();

		List<RentalSearchListDto> response = result.stream()
				.map(rental -> modelMapperService.forDto().map(rental, RentalSearchListDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<RentalSearchListDto>>(response, "Rental liste");
	}

	@Override
	public Result add(CreateRentalRequest createRentalRequest) {
		Result result = BusinessRules.run(checkCarIsReturned(createRentalRequest.getCarId()),
				checkCompareUserAndCarFindeksScore(createRentalRequest.getIndividualCustomerId(),createRentalRequest.getCarId()),
						checkCarIsMaintenance(createRentalRequest.getCarId()));
		if (result != null) {
			return result;
		}
		Rental rental = modelMapperService.forRequest().map(createRentalRequest, Rental.class);
		rentalDao.save(rental);
		return new SuccessResult("Araba kiraland??");
	}

	@Override
	public Result delete(DeleteRentalRequest deleteRentalRequest) {
		Rental rental = modelMapperService.forRequest().map(deleteRentalRequest, Rental.class);
		rentalDao.delete(rental);
		return new SuccessResult("Araba silindi");
	}

	@Override
	public Result update(UpdateRentalRequest updateRentalRequest) {
		Rental rental = modelMapperService.forRequest().map(updateRentalRequest, Rental.class);
        RentalDetail result = this.rentalDao.getRentalDetails(updateRentalRequest.getId());
        rental.setRentDate(result.getRentDate());
        this.rentalDao.save(rental);
        return new SuccessResult("Updated");
		
	}

	public Result checkCarIsReturned(int carId) {
		RentalSearchListDto rental = this.rentalDao.getByCarIdWhereReturnDateIsNull(carId);
		if (rental != null) {
			return new ErrorResult("Ara?? ??uan da m??sait de??il.");
		}
		return new SuccessResult();
	}
	
	private Result checkCarIsMaintenance(int carId) {
		MaintenanceDto maintenanceDto = this.rentalDao.getByCarIdWhereMaintenanceReturnDateIsNull(carId);
		if (maintenanceDto != null) {
			return new ErrorResult("Ara?? ??uan bak??mda ve m??sait de??il");
		}
		return new SuccessResult();
	}
	
	/*@Override
	public DataResult<RentalSearchListDtos> getById(int id) {
			Maintenance maintenance = this.maintenanceDao.findById(maintenanceId).get();
			MaintenanceDto response = this.modelMapperService.forDto().map(maintenance, MaintenanceDto.class);
		return new SuccessDataResult<MaintenanceDto>(response);
	}*/
	
	private Result checkCompareUserAndCarFindeksScore(int userId ,int carId) {
		DataResult<CarSearchListDto> car = this.carService.getById(carId);
		
		int user = this.userService.getById(userId).getData().getFindeksScore();
		if(car.getData().getMinFindeksScore() >= user) {
			return new ErrorResult("findeksScore not insufficient ");
		}
		return new SuccessResult();
	}

}
