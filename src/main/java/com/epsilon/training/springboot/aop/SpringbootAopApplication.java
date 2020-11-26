package com.epsilon.training.springboot.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.epsilon.training.springboot.aop.model.Employee;
import com.epsilon.training.springboot.aop.service.EmployeeService;

@SpringBootApplication
public class SpringbootAopApplication implements CommandLineRunner{
	
	@Autowired
	private EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Employee emp1 = new Employee(1, "Harshitha", 10000, 23, "Female");
		Employee emp2 = new Employee(2, "Akshay", 100001, 23, "Male");
		Employee emp3 = new Employee(3, "Hariom", 100002, 23, "Male");

		employeeService.save(emp1);
		employeeService.save(emp2);
		employeeService.save(emp3);
		
	}

}
