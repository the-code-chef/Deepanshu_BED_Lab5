package gl.lab5.springproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gl.lab5.springproject.dao.MyRepository;
import gl.lab5.springproject.model.Employee;

@Service
public class MyServiceImpl implements MyService {

	@Autowired
	MyRepository repo;

	@Override
	public List<Employee> getAllEmployees() {
		return repo.findAll();

	}

	@Override
	public void saveEmployee(Employee emp) {
		repo.save(emp);
	}

	@Override
	public int deleteById(int id) {
		repo.deleteById(id);
		return id;
	}

	@Override
	public Employee findById(int id) {
		Optional<Employee> optemp = repo.findById(id);
		if (optemp.isPresent()) {
			return optemp.get();
		} else {
			throw new RuntimeException("Employee does not exists for Id : " + id);
		}
	}

}
