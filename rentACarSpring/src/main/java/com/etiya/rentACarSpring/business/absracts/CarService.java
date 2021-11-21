package com.etiya.rentACarSpring.business.absracts;

import java.util.List;

import com.etiya.rentACarSpring.business.dtos.CarSearchListDto;
import com.etiya.rentACarSpring.business.requests.CreateCarRequest;
import com.etiya.rentACarSpring.business.requests.DeleteCarRequest;
import com.etiya.rentACarSpring.business.requests.UpdateCarRequest;
import com.etiya.rentACarSpring.core.utilities.results.DataResult;
import com.etiya.rentACarSpring.core.utilities.results.Result;

public interface CarService {
	DataResult<List<CarSearchListDto>> getAll();
	Result save(CreateCarRequest createCarRequest);
	Result update(UpdateCarRequest updateCarRequest);
	Result delete(DeleteCarRequest deleteCarRequest);
}
