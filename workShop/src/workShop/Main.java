package workShop;

public class Main {

	public static void main(String[] args) {
		
		ProductManager productManager = new ProductManager(new JpaProductDao(), new LoggerManager(new FileLogger(), new DatabaseLogger()));
		productManager.save(null);
	}

}
