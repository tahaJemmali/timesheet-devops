package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Employee;

public interface IEmployeeService { 
	 
	List<Employee> retrieveAllEmployees(); 
	Employee addEmployee(Employee u);
	void deleteEmployee(String id);
	Employee updateEmployee(Employee u);
	Employee retrieveEmployee(String id);
	Employee login(String username,String password);

} 
 