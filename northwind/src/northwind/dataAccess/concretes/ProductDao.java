package northwind.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import northwind.dataAccess.abstracts.ProductRepository;
import northwind.entities.concretes.Product;

public class ProductDao implements ProductRepository{
	
	List<Product> products;
	
	public ProductDao() {
		super();
		this.products = new ArrayList<Product>();
	}

	@Override
	public void add(Product product) {
		products.add(product);
		
	}

	@Override
	public void delete(Product product) {
		
	}

	@Override
	public void update(Product product) {
		
	}

	@Override
	public Product getById(int id) {
		return null;
	}

	@Override
	public List<Product> getAll() {
		return products;
	}

}
