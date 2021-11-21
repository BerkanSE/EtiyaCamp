package com.etiya.rentACarSpring.business.absracts;

import com.etiya.rentACarSpring.business.requests.CreateBrandRequest;
import com.etiya.rentACarSpring.business.requests.DeleteBrandRequest;
import com.etiya.rentACarSpring.business.requests.UpdateBrandRequest;
import com.etiya.rentACarSpring.core.utilities.results.Result;

public interface BrandService {
	Result save(CreateBrandRequest createBrandRequest);
	Result update(UpdateBrandRequest updateBrandRequest);
	Result delete(DeleteBrandRequest deleteBrandRequest);
}
