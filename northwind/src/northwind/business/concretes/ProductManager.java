package northwind.business.concretes;

import java.util.List;

import northwind.business.abstracts.ProductService;
import northwind.dataAccess.abstracts.ProductRepository;
import northwind.entities.concretes.Product;

public class ProductManager implements ProductService {

	private ProductRepository productRepository;
	
	public ProductManager(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> getAll() {
		return this.productRepository.getAll();
	}

	@Override
	public void add(Product product) {
		if (checkIfProductNameExists(product.getProductName()) || checkIfProductCountOfCategory(product.getCategoryId())
				|| checkIfProductPriceNegative(product.getUnitPrice()) || checkIfProductPriceInSpecificCategory(product)) {
			System.out.println(product.getProductName() + " ürünü verilen kurallara uymuyor. Ürün eklenemedi!");
		}
		else {
			this.productRepository.add(product);
		}
		
	}
	
	private boolean checkIfProductNameExists(String productName) {
		for (Product product : getAll()) {
			if (product.getProductName() == productName) {
				return true;
			}
		}
		return false;
	}
	
	private boolean checkIfProductCountOfCategory(int categoryId) {
		int categoryCount = 0;
		for (Product product : getAll()) {
			if (product.getCategoryId() == categoryId) {
				categoryCount ++;
			}
		}
		if (categoryCount >= 5) {
			return true;
		}
		return false;
	}
	
	private boolean checkIfProductPriceNegative(double unitPrice) {
		if (unitPrice <= 0) {
			return true;
		}
		return false;
	}
	
	private boolean checkIfProductPriceInSpecificCategory(Product product) {
		if (product.getCategoryId() == 3 && product.getUnitPrice() < 10) {
			return true;
		}
		return false;
	}

}
