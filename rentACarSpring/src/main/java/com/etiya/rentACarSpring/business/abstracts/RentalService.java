package com.etiya.rentACarSpring.business.abstracts;

import java.util.List;

import com.etiya.rentACarSpring.business.dtos.RentalSearchListDto;
import com.etiya.rentACarSpring.business.requests.creates.CreateRentalRequest;
import com.etiya.rentACarSpring.business.requests.creates.CreateUserRequest;
import com.etiya.rentACarSpring.business.requests.deletes.DeleteRentalRequest;
import com.etiya.rentACarSpring.business.requests.deletes.DeleteUserRequest;
import com.etiya.rentACarSpring.business.requests.updates.UpdateRentalRequest;
import com.etiya.rentACarSpring.business.requests.updates.UpdateUserRequest;
import com.etiya.rentACarSpring.core.utilities.results.DataResult;
import com.etiya.rentACarSpring.core.utilities.results.Result;
import com.etiya.rentACarSpring.entities.Rental;
import com.etiya.rentACarSpring.entities.User;

public interface RentalService {

	DataResult<List<RentalSearchListDto>> getAll();
	Result add(CreateRentalRequest createRentalRequest);
	Result update(UpdateRentalRequest updateRentalRequest);
	Result delete(DeleteRentalRequest deleteRentalRequest);
}
