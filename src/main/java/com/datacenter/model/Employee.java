package com.datacenter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Employee {

	@Id
	@SequenceGenerator(name = "employee_idemployee_seq", sequenceName = "employee_idemployee_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_idemployee_seq")
	@JsonIgnore
	private Long idemployee;

	private String name;
	
	private Double salary;

	public Employee() {

	}

	public Employee(String name, Double salary) {
		this.name = name;
		this.salary = salary;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getIdemployee() {
		return idemployee;
	}

	public void setIdemployee(Long idEmployee) {
		this.idemployee = idEmployee;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + idemployee + ", name=" + name + ", salary=" + salary + "]";
	}

}