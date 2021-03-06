package com.etiya.RentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.RentACar.business.abstracts.MaintenanceService;
import com.etiya.RentACar.business.abstracts.RentalService;
import com.etiya.RentACar.business.dtos.CarSearchListDto;
import com.etiya.RentACar.business.dtos.MaintenanceDto;
import com.etiya.RentACar.business.dtos.MaintenanceSearchListDto;
import com.etiya.RentACar.business.dtos.RentalSearchListDto;
import com.etiya.RentACar.business.requests.maintenance.CreateMaintenanceRequest;
import com.etiya.RentACar.business.requests.maintenance.DeleteMaintenanceRequest;
import com.etiya.RentACar.business.requests.maintenance.UpdateMaintenanceRequest;
import com.etiya.RentACar.core.utilities.Message.Messages;
import com.etiya.RentACar.core.utilities.business.BusinessRules;
import com.etiya.RentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.RentACar.core.utilities.results.DataResult;
import com.etiya.RentACar.core.utilities.results.ErrorResult;
import com.etiya.RentACar.core.utilities.results.Result;
import com.etiya.RentACar.core.utilities.results.SuccessDataResult;
import com.etiya.RentACar.core.utilities.results.SuccessResult;
import com.etiya.RentACar.dataAccess.abstracts.MaintenanceDao;
import com.etiya.RentACar.entites.Car;
import com.etiya.RentACar.entites.Maintenance;

@Service
public class MaintenanceManager implements MaintenanceService {

	private MaintenanceDao maintenanceDao;
	private ModelMapperService modelMapperService;
	private RentalService rentalService;

	@Autowired
	public MaintenanceManager(MaintenanceDao maintenanceDao, ModelMapperService modelMapperService,
			RentalService rentalService) {
		this.maintenanceDao = maintenanceDao;
		this.modelMapperService = modelMapperService;
		this.rentalService = rentalService;
	}

	@Override
	public DataResult<List<MaintenanceSearchListDto>> getAll() {
		List<Maintenance> result = this.maintenanceDao.findAll();
		List<MaintenanceSearchListDto> response = result.stream()
				.map(maintenance -> modelMapperService.forDto().map(maintenance, MaintenanceSearchListDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<MaintenanceSearchListDto>>(response, "Arac bak??mda olan ara??lar");
	}

	@Override
	public Result add(CreateMaintenanceRequest createMaintenanceRequest) {
		Result result = BusinessRules.run(checkByCarReturnFromRental(createMaintenanceRequest.getCarId()));

		if (result != null) {
			return result;
		}

		Maintenance maintenance = this.modelMapperService.forRequest().map(createMaintenanceRequest, Maintenance.class);
		this.maintenanceDao.save(maintenance);
		return new SuccessResult("Ara?? Bak??ma G??nderildi");
	}

	@Override
	public Result update(UpdateMaintenanceRequest updateMaintenanceRequest) {
		Maintenance maintenance = this.modelMapperService.forRequest().map(updateMaintenanceRequest, Maintenance.class);

		// MaintenanceDto result = getById(updateMaintenanceRequest.getId()).getData();
		this.maintenanceDao.save(maintenance);
		return new SuccessResult("Ara?? Bak??m?? g??ncellendi");
	}

	@Override
	public Result delete(DeleteMaintenanceRequest deleteMaintenanceRequest) {

		this.maintenanceDao.deleteById(deleteMaintenanceRequest.getId());
		return new SuccessResult("Ara?? Bak??m Listesinden Silindi");
	}

	@Override
	public DataResult<MaintenanceSearchListDto> getById(int maintenanceId) {
		Maintenance maintenance = this.maintenanceDao.findById(maintenanceId).get();
		MaintenanceSearchListDto response = this.modelMapperService.forDto().map(maintenance, MaintenanceSearchListDto.class);
		return new SuccessDataResult<MaintenanceSearchListDto>(response);
	}

	// Kiralanm???? ara?? bak??ma gidemez
	private Result checkByCarReturnFromRental(int carId) {
		if (!this.rentalService.checkCarIsReturned(carId).isSuccess()) {
			return new ErrorResult("Ara?? ??uan da bak??ma gidemez.");
		}
		return new SuccessResult();

	}
	/*
	@Override
	// Bak??mdan d??nd?? m???
	public Result checkCarIsMaintenance(int carId) {
		MaintenanceDto maintenanceDto = this.maintenanceDao.getByCarIdWhereReturnDateIsNull(carId);
		if (maintenanceDto != null) {
			return new ErrorResult("Ara?? ??uan da bak??mda ve m??sait de??il.");
		}
		return new SuccessResult();
	}
	*/

}
