package workShop;

import java.util.ArrayList;

public class CustomerManager implements CustomerService{

	private CustomerDao customerDao;
	
	public CustomerManager(CustomerDao customerDao) {
		super();
		this.customerDao = customerDao;
	}

	@Override
	public void save(Customer customer) {
		customerDao.save(customer);
		
	}

	@Override
	public ArrayList<Customer> list() {
		
		return null;
	}

}
