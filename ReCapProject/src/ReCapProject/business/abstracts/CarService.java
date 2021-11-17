package ReCapProject.business.abstracts;

import java.util.List;

import ReCapProject.core.utilities.results.DataResult;
import ReCapProject.core.utilities.results.Result;
import ReCapProject.entities.concretes.Car;

public interface CarService {
	Result add(Car car);
	Result remove(int carId);
	Result update(int carId, Car car);
	Car getById(int carId);
	DataResult<List<Car>> getAll();
}
