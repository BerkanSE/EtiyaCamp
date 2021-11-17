package ReCapProject.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import ReCapProject.dataAccess.abstracts.CarRepository;
import ReCapProject.entities.concretes.Car;

public class CarDao implements CarRepository{

	List<Car> cars;
	
	public CarDao() {
		super();
		cars = new ArrayList<Car>();
	}

	@Override
	public void insert(Car car) {
		cars.add(car);
	}

	@Override
	public void delete(int id) {
		cars.remove(id);
	}

	@Override
	public void update(int id, Car car) {
		cars.set(id, car);
	}

	@Override
	public Car getById(int id) {
		return cars.get(id - 1);
	}

	@Override
	public List<Car> getAll() {
		return cars;
	}

}
