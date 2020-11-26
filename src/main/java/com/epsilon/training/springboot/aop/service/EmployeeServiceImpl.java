package com.epsilon.training.springboot.aop.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epsilon.training.springboot.aop.dao.EmployeeDAO;
import com.epsilon.training.springboot.aop.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	@Transactional
	public Employee save(Employee employee) {
		return employeeDAO.save(employee);
	}

	@Override
	@Transactional
	public List<Employee> getAllEmployees() {
		return employeeDAO.getAllEmployees();
	}

	@Override
	@Transactional
	public Employee findEmployeeById(int Id) {
		return employeeDAO.findEmployeeById(Id);
	}

	@Override
	@Transactional
	public List<Employee> findEmployeeByName(String Name) {
		return employeeDAO.findEmployeeByName(Name);
	}

	@Override
	@Transactional
	public List<Employee> findEmployeeByNameAndAge(String Name, int Age) {
		return employeeDAO.findEmployeeByNameAndAge(Name, Age);
	}

	@Override
	@Transactional
	public boolean updateEmployee(Employee employee) {
		return employeeDAO.updateEmployee(employee);
	}

	@Override
	@Transactional
	public boolean deleteEmployee(int Id) {
		return employeeDAO.deleteEmployee(Id);
	}

	@Override
	@Transactional
	public boolean deleteEmployee(String Name) {
		return employeeDAO.deleteEmployee(Name);
	}

}
