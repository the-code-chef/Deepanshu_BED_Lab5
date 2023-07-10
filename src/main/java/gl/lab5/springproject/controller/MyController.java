package gl.lab5.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gl.lab5.springproject.model.Employee;
import gl.lab5.springproject.service.MyService;

@Controller
@RequestMapping("/employees")
public class MyController {

	@Autowired
	public MyService svc;

	@GetMapping("/")
	public String getAllEmployees(Model model) {
		model.addAttribute("employees", svc.getAllEmployees());
		return "employees";
	}

	@GetMapping("/new")
	public String addEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "create_emp";
	}

	@GetMapping("/edit/{id}")
	public String editEmployee(@PathVariable(name = "id") Integer id, Model model) {
		model.addAttribute("employee", svc.findById(id));
		return "edit_emp";
	}

	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable(name = "id") Integer id) {
		svc.deleteById(id);
		return "redirect:/employees/";
	}

	@PostMapping("/save")
	public String createEmployee(@ModelAttribute(name = "employee") Employee emp) {
		svc.saveEmployee(emp);
		return "redirect:/employees/";
	}

	@PostMapping("/save/{id}")
	public String createEmployee(@PathVariable(name = "id") Integer id,
			@ModelAttribute(name = "employee") Employee emp) {
		emp.setEmpId(id);
		svc.saveEmployee(emp);
		return "redirect:/employees/";
	}
}
