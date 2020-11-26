package com.epsilon.training.springboot.aop.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.epsilon.training.springboot.aop.dao.EmployeeDAO;
import com.epsilon.training.springboot.aop.model.Employee;

@Repository
public class EmployeeRepository implements EmployeeDAO {

	private EntityManager entityManager;

	@Autowired
	public EmployeeRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Employee save(Employee employee) {
		Employee emp = entityManager.merge(employee);
		return emp;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<Employee> getAllEmployees() {

		List<Employee> employees = null;
		Query query = (Query) entityManager.createQuery("from Employee");
		employees = query.getResultList();

		return employees;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Employee findEmployeeById(int Id) {
		
		Employee employee = null;
		Query query = (Query) entityManager.createQuery("from Employee where Id=:Id");
		query.setParameter("Id", Id);
		List<Employee> employees = query.getResultList();
		if (null != employees && employees.size() > 0) {
			employee = employees.get(0);
		}
		
		return employee;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findEmployeeByName(String Name) {
		
		List<Employee> employees = null;
		Query query = (Query) entityManager.createQuery("from Employee where Name=:Name");
		query.setParameter("Name", Name);
		employees = query.getResultList();
		
		return employees;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findEmployeeByNameAndAge(String Name, int Age) {
		
		List<Employee> employees = null;
		Query query = (Query) entityManager.createQuery("from Employee where Name=:Name and Age=:Age");
		query.setParameter("Name", Name);
		query.setParameter("Age", Age);
		employees = query.getResultList();
		return employees;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		Query query = (Query) entityManager
				.createQuery("update Employee set Name=:Name, Salary=:Salary, Age=:Age, Gender=:Gender");
		query.setParameter("Name", employee.getName());
		query.setParameter("Salary", employee.getSalary());
		query.setParameter("Age", employee.getAge());
		query.setParameter("Gender", employee.getGender());
		int result = query.executeUpdate();
		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteEmployee(int Id) {
		Query query = (Query) entityManager.createQuery("delete from Employee where Id=:Id");
		query.setParameter("Id", Id);
		int result = query.executeUpdate();
		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteEmployee(String Name) {
		Query query = (Query) entityManager.createQuery("delete from Employee where Name=:Name");
		query.setParameter("Name", Name);
		int result = query.executeUpdate();
		if (result > 0) {
			return true;
		}
		return false;
	}

}
