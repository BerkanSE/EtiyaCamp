package northwind.business.abstracts;

import java.util.List;

import northwind.entities.concretes.Employee;

public interface EmployeeService {
	List<Employee> getAll();
	void add(Employee employee);
}
