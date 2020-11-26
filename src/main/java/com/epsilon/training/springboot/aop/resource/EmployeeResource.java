package com.epsilon.training.springboot.aop.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.epsilon.training.springboot.aop.model.Employee;
import com.epsilon.training.springboot.aop.service.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeResource {

	
	private EmployeeService employeeService;

	@Autowired
	public EmployeeResource(EmployeeService service) {
		this.employeeService = service;
	}

	@RequestMapping(value = "/save", method = RequestMethod.PUT)
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.save(employee);
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<Employee> getAllEmployees() {
		
		try {
			return employeeService.getAllEmployees();
		} catch (Exception e) {
			
		}
		return null;
	}

	@RequestMapping(value = "/getById/{Id}", method = RequestMethod.GET)
	public Employee getEMployeeById(@PathVariable int Id) {
		return employeeService.findEmployeeById(Id);
	}

	@RequestMapping(value = "/getByName/{Name}", method = RequestMethod.GET)
	public List<Employee> getEMployeeByName(@PathVariable String Name) {
		return employeeService.findEmployeeByName(Name);
	}

	@RequestMapping(value = "/getByNameAndAge/{Name}/{Age}", method = RequestMethod.GET)
	public List<Employee> getEMployeeByNameAndAge(@PathVariable String Name, @PathVariable int Age) {
		return employeeService.findEmployeeByNameAndAge(Name, Age);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public boolean updateEMployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}

	@RequestMapping(value = "/delete/Name/{Name}", method = RequestMethod.DELETE)
	public boolean deleteByName(@PathVariable String Name) {
		return employeeService.deleteEmployee(Name);
	}
}
