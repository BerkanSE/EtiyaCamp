package workShop;

public class JpaProductDao implements ProductDao {

	@Override
	public void save() {
		System.out.println("Jpa ile eklendi");
		
	}

}
