package ReCapProject.business.concretes;

import java.util.List;

import ReCapProject.business.abstracts.CarService;
import ReCapProject.core.utilities.results.DataResult;
import ReCapProject.core.utilities.results.ErrorResult;
import ReCapProject.core.utilities.results.Result;
import ReCapProject.core.utilities.results.SuccessDataResult;
import ReCapProject.core.utilities.results.SuccessResult;
import ReCapProject.dataAccess.abstracts.CarRepository;
import ReCapProject.entities.concretes.Car;

public class CarManager implements CarService{

	private CarRepository carRepository;
	
	public CarManager(CarRepository carRepository) {
		super();
		this.carRepository = carRepository;
	}

	@Override
	public Result add(Car car) {
		this.carRepository.insert(car);
		return new SuccessResult("Araç eklendi.");
	}

	@Override
	public Result remove(int carId) {
		int index;
		for (Car item : this.carRepository.getAll()) {
			if (item.getCarId() == carId) {
				index = this.carRepository.getAll().indexOf(item);
				this.carRepository.delete(index);
				return new SuccessResult("Araç silindi.");
			}
		}
		return new ErrorResult("Araç bulunamadı. Silme işlemi geçersiz!");
	}

	@Override
	public Result update(int carId, Car car) {
		int index;
		for (Car item : this.carRepository.getAll()) {
			if (item.getCarId() == carId) {
				index = this.carRepository.getAll().indexOf(item);
				this.carRepository.update(index, car);
				return new SuccessResult("Araç güncellendi.");
			}
		}
		return new ErrorResult("Araç bulunamadı. Güncelleme işlemi geçersiz!");
	}

	@Override
	public Car getById(int carId) {
		return this.carRepository.getById(carId);
	}

	@Override
	public DataResult<List<Car>> getAll() {
		return new SuccessDataResult<List<Car>>(this.carRepository.getAll());
	}

}
