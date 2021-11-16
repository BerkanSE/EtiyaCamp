package northwind.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import northwind.dataAccess.abstracts.CategoryRepository;
import northwind.entities.concretes.Category;

public class CategoryDao implements CategoryRepository{

	List<Category> categories;
	
	
	public CategoryDao() {
		categories = new ArrayList<Category>();
	}

	@Override
	public void add(Category category) {
		categories.add(category);
	}

	@Override
	public void delete(Category category) {
		
	}

	@Override
	public void update(Category category) {
		
	}

	@Override
	public Category getById(int id) {
		return null;
	}

	@Override
	public List<Category> getAll() {
		return categories;
	}

}
