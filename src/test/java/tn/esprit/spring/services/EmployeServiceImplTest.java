package tn.esprit.spring.services;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class EmployeServiceImplTest {

	@Autowired
	IEmployeService us;
	
	@Test
	@Order(1)
	public void testRetriveAllEmployes(){
		List<Employe> listEmployes =us.retrieveAllEmployes();
		Assertions.assertNotEquals(0,listEmployes.size());
	}
	@Test
	@Order(2)
	public void testAddEmploye() {
		
		    Employe Employe= new Employe("sami", "ben ali","taha.jemmali@gmail.com","12345678",false, Role.ADMINISTRATEUR );
				Employe u_saved = us.addEmploye(Employe); 
				Assertions.assertEquals(Employe,u_saved);
	}

	@Test
	@Order(3)
	public void testUpdateEmploye() { 
		    Employe Employe= new Employe("taha", "jemmali","taha.jemmali@gmail.com","12345678",false, Role.ADMINISTRATEUR );
			Employe u_saved = us.updateEmploye(Employe); 
			Assertions.assertEquals(Employe,u_saved);
	}

	@Test
	@Order(4)
	public void testDeleteEmploye() {
		int a=us.deleteEmploye("24"); 
		Assertions.assertEquals(1,a);
	}

	@Test
	@Order(5)
	public void testRetrieveEmploye() {
		Employe u =  us.retrieveEmploye("2"); 
		Assertions.assertEquals(Long.parseLong("2"),u.getId());
	}
	@Test
	@Order(6)
	public void testLogin() {
		Employe u =  us.login("taha.jemmali@gmail.com", "12345678"); 
		Assertions.assertNotNull(u);
	}
}
