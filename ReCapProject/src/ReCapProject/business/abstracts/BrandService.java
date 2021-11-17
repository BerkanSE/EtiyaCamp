package ReCapProject.business.abstracts;

import java.util.List;

import ReCapProject.core.utilities.results.DataResult;
import ReCapProject.core.utilities.results.Result;
import ReCapProject.entities.concretes.Brand;

public interface BrandService {
	Result add(Brand brand);
	Result remove(int brandId);
	Result update(int brandId, Brand brand);
	Brand getById(int brandId);
	DataResult<List<Brand>> getAll();
}
