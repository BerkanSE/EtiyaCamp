package com.etiya.rentACarSpring.business.absracts;

import com.etiya.rentACarSpring.business.requests.CreateColorRequest;
import com.etiya.rentACarSpring.business.requests.DeleteColorRequest;
import com.etiya.rentACarSpring.business.requests.UpdateColorRequest;
import com.etiya.rentACarSpring.core.utilities.results.Result;

public interface ColorService {
	Result save(CreateColorRequest createColorRequest);
	Result update(UpdateColorRequest updateColorRequest);
	Result delete(DeleteColorRequest deleteColorRequest);
}
