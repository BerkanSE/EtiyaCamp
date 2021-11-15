package workShop;

import java.util.ArrayList;

public interface CustomerDao {
	void save(Customer customer);
	ArrayList<Customer> list();
}
