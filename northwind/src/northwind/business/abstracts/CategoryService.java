package northwind.business.abstracts;

import java.util.List;

import northwind.entities.concretes.Category;

public interface CategoryService {
	List<Category> getAll();
	void add(Category category);
}
