package com.epsilon.training.springboot.aop.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable {

	private static final long serialVersionUID = -2503433060652533244L;

	@Id
	@Column(name = "ID")
	private int Id;
	@Column(name = "NAME")
	private String Name;
	@Column(name = "SALARY")
	private int Salary;
	@Column(name = "AGE")
	private int Age;
	@Column(name = "GENDER")
	private String Gender;

	public Employee() {

	}

	public Employee(int id, String name, int salary, int age, String gender) {

		this.Id = id;
		this.Name = name;
		this.Salary = salary;
		this.Age = age;
		this.Gender = gender;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getSalary() {
		return Salary;
	}

	public void setSalary(int salary) {
		Salary = salary;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	@Override
	public String toString() {
		return "Name: " + Name + "\nSalary: " + Salary + "\nAge: " + Age + "\nGender: " + Gender;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			if (o instanceof Employee) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return (32 * Id) + Name.hashCode();
	}
}
