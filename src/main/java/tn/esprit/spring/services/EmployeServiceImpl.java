package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Employee;
import tn.esprit.spring.repository.EmployeRepository;

@Service
public class EmployeServiceImpl implements IEmployeeService {

	@Autowired
	EmployeRepository employeRepository;

	private static final Logger l=LogManager.getLogger(EmployeServiceImpl.class);
	@Override
	public Employee login(String username, String password) {
		l.info("In login() : ");
		Employee u =  employeRepository.getEmployeeByEmailAndPassword(username, password);
		l.info("Out of login() : found Employee : "+u);
		return u; 
	}
	
	@Override
	public List<Employee> retrieveAllEmployees() { 
		List<Employee> Employees = null; 
		try {
	
			l.info("In retrieveAllEmployee() ");
			Employees = (List<Employee>) employeRepository.findAll();  
			for (Employee Employee : Employees) {
				l.debug("Employee +++: "+Employee);
			} 
			l.info("Out of retrieveAllEmployee() with success ");
		}catch (Exception e) {
			l.error("Error in  retrieveAllEmployee() with Error: "+ e);
		}

		return Employees;
	}


	@Override
	public Employee addEmployee(Employee u) {
		l.info("In addEmployee() : ");
		Employee u_saved = employeRepository.save(u); 
		l.info("Out of addEmployee() : saved Employee: "+u_saved);
		return u_saved; 
	}

	@Override 
	public Employee updateEmployee(Employee u) { 
		l.info("In updateEmployee() : ");
		Employee u_saved = employeRepository.save(u); 
		l.info("Out of updateEmployee() : updated Employee: "+u_saved);
		return u_saved; 
	}

	@Override
	public void deleteEmployee(String id) {
		l.info("In deleteEmployee() : ");
		employeRepository.deleteById(Long.parseLong(id)); 
		l.info("Out of deleteEmployee() : deleted Employee id : "+id);
	}

	@Override
	public Employee retrieveEmployee(String id) {
		l.info("In retrieveEmployee() : ");
		Employee u =  employeRepository.findById(Long.parseLong(id)).get(); 
		l.info("Out of retrieveEmployee() : found Employee : "+u);
		return u; 
	}




}
