package gl.lab5.springproject.service;

import java.util.List;

import gl.lab5.springproject.model.Employee;

public interface MyService {

	List<Employee> getAllEmployees();

	void saveEmployee(Employee emp);

	int deleteById(int id);

	Employee findById(int id);

}
