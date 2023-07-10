package gl.lab5.springproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Table(name = "employee")
@Entity
public class Employee {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "emp_id")
	int empId;
	@Column(name = "emp_first_name")
	String empFirstName;
	@Column(name = "emp_last_name")
	String empLastName;
	@Column(name = "emp_email")
	String empEmail;

	public Employee() {
		super();
	}

}
