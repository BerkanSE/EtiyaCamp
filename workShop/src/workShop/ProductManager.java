package workShop;

import java.util.ArrayList;

public class ProductManager implements ProductService{

	private ProductDao productDao;
	private LoggerService loggerService;
	
	public ProductManager(ProductDao productDao, LoggerService loggerService) {
		super();
		this.productDao = productDao;
		this.loggerService = loggerService;
	}

	@Override
	public void save(Product product) {
		productDao.save();
		loggerService.log();
		
	}

	@Override
	public ArrayList<Product> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
