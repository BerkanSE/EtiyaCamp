package ReCapProject.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import ReCapProject.dataAccess.abstracts.BrandRepository;
import ReCapProject.entities.concretes.Brand;

public class BrandDao implements BrandRepository{

	List<Brand> brands;
	
	public BrandDao() {
		super();
		this.brands = new ArrayList<Brand>();
	}

	@Override
	public void insert(Brand brand) {
		brands.add(brand);	
	}

	@Override
	public void delete(int id) {
		brands.remove(id);
	}

	@Override
	public void update(int id, Brand brand) {
		brands.set(id, brand);
	}

	@Override
	public Brand getById(int id) {
		return brands.get(id - 1);
	}

	@Override
	public List<Brand> getAll() {
		// TODO Auto-generated method stub
		return brands;
	}

	
}
