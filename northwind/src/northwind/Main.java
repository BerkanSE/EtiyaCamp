package northwind;

import northwind.business.abstracts.CategoryService;
import northwind.business.abstracts.EmployeeService;
import northwind.business.abstracts.ProductService;
import northwind.business.concretes.CategoryManager;
import northwind.business.concretes.EmployeeManager;
import northwind.business.concretes.ProductManager;
import northwind.dataAccess.concretes.CategoryDao;
import northwind.dataAccess.concretes.EmployeeDao;
import northwind.dataAccess.concretes.ProductDao;
import northwind.entities.concretes.Category;
import northwind.entities.concretes.Employee;
import northwind.entities.concretes.Product;

public class Main {

	public static void main(String[] args) {
		ProductService productService = new ProductManager(new ProductDao());
		productService.add(new Product(1, 1, "Elma", 10));
		productService.add(new Product(2, 1, "Armut", 20));
		productService.add(new Product(3, 1, "Karpuz", 30));
		productService.add(new Product(4, 1, "Üzüm", 40));
		productService.add(new Product(5, 1, "İncir", 50));
		
		//	---- Hatalı Eklemeler ----
		
		//Aynı isimde ürün ekleme:
		productService.add(new Product(6, 2, "İncir", 25));
		//Aynı kategoride 5 den fazla 6.ürünü ekleme:
		productService.add(new Product(7, 1, "Kavun", 48));
		//0 ve Negatif fiyatlı ürün ekleme:
		productService.add(new Product(8, 3, "Ayran", 0));
		//CategoryId'si 3 olan ve ürün fiyatı 10 dan düşük ürün ekleme:
		productService.add(new Product(9, 3, "Kola", 9));
		
		for (Product product : productService.getAll()) {
			System.out.println(product.getProductName());
		}
		
		CategoryService categoryService = new CategoryManager(new CategoryDao());
		categoryService.add(new Category(1,"Meyve"));
		categoryService.add(new Category(2,"Sebze"));
		categoryService.add(new Category(3,"İcecek"));
		
		//for (Category category : categoryService.getAll()) {
		//	System.out.println(category.getCategoryName());
		//}
		
		EmployeeService employeeService = new EmployeeManager(new EmployeeDao());
		employeeService.add(new Employee(1, "Berkan", "Senger", "Balıkesir"));
		employeeService.add(new Employee(1, "Erdi", "Tuna", "Ankara"));
		
		//for (Employee employee : employeeService.getAll()) {
		//	System.out.println(employee.getFirstName());
		//}
	}

}
