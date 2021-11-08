package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.EmployeRepository;

@Service
public class EmployeServiceImpl implements IEmployeService {

	@Autowired
	EmployeRepository employeRepository;

	private static final Logger l=LogManager.getLogger(EmployeServiceImpl.class);
	@Override
	public Employe login(String username, String password) {
		l.info("In login() : ");
		Employe u =  employeRepository.getEmployeeByEmailAndPassword(username, password).get(0);
		l.info("Out of login() : found Employe : "+u);
		return u; 
	}
	
	@Override
	public List<Employe> retrieveAllEmployes() { 
		List<Employe> Employes = null; 
		try {
	
			l.info("In retrieveAllEmploye() ");
			Employes = (List<Employe>) employeRepository.findAll();  
			for (Employe Employe : Employes) {
				l.debug("Employe +++: "+Employe);
			} 
			l.info("Out of retrieveAllEmploye() with success ");
		}catch (Exception e) {
			l.error("Error in  retrieveAllEmploye() with Error: "+ e);
		}

		return Employes;
	}


	@Override
	public Employe addEmploye(Employe u) {
		l.info("In addEmploye() : ");
		Employe u_saved = employeRepository.save(u); 
		l.info("Out of addEmploye() : saved Employe: "+u_saved);
		return u_saved; 
	}

	@Override 
	public Employe updateEmploye(Employe u) { 
		l.info("In updateEmploye() : ");
		Employe u_saved = employeRepository.save(u); 
		l.info("Out of updateEmploye() : updated Employe: "+u_saved);
		return u_saved; 
	}

	@Override
	public int deleteEmploye(String id) {
	try{
		l.info("In deleteEmploye() : ");
		employeRepository.deleteById(Long.parseLong(id)); 
		l.info("Out of deleteEmploye() : deleted Employe id : "+id);
		return 1;
	}catch (Exception e){
		return -1;
	}
	}

	@Override
	public Employe retrieveEmploye(String id) {
		l.info("In retrieveEmploye() : ");
		Employe u =  employeRepository.findById(Long.parseLong(id)).orElse(new Employe()); 
		l.info("Out of retrieveEmploye() : found Employe : "+u);
		return u; 
	}




}
