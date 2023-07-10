package gl.lab5.springproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import gl.lab5.springproject.model.Employee;

public interface MyRepository extends JpaRepository<Employee, Integer> {

}
