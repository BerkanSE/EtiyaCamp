package northwind.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import northwind.dataAccess.abstracts.EmployeeRepository;
import northwind.entities.concretes.Employee;

public class EmployeeDao implements EmployeeRepository {

	List<Employee> employees;
	
	public EmployeeDao() {
		this.employees = new ArrayList<Employee>();
	}

	@Override
	public void add(Employee employee) {
		employees.add(employee);
	}

	@Override
	public void delete(Employee employee) {
		
	}

	@Override
	public void update(Employee employee) {
		
	}

	@Override
	public Employee getById(int id) {
		return null;
	}

	@Override
	public List<Employee> getAll() {
		return employees;
	}

}
