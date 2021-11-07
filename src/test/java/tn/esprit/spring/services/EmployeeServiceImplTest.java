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

import tn.esprit.spring.entities.Employee;
import tn.esprit.spring.entities.Role;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class EmployeeServiceImplTest {

	@Autowired
	IEmployeeService us;
	
	@Test
	@Order(1)
	public void testRetriveAllEmployes(){
		List<Employee> listEmployes =us.retrieveAllEmployees();
		Assertions.assertEquals(0,listEmployes.size());
	}
	@Test
	@Order(2)
	public void testAddEmploye() {

		    Employee employee= new Employee("sami", "ben ali","taha.jemmali@gmail.com","12345678",false, Role.ADMINISTRATEUR );
				Employee u_saved = us.addEmployee(employee); 
				Assertions.assertEquals(employee,u_saved);
	}

	@Test
	@Order(3)
	public void testUpdateEmploye() { 
		    Employee employee= new Employee("taha", "jemmali","sami.benali@gmail.com","12345678",false, Role.CHEF_DEPARTEMENT );
			Employee u_saved = us.updateEmployee(employee); 
			Assertions.assertNotEquals(employee,u_saved);
	}

	@Test
	@Order(4)
	public void testDeleteEmploye() {
		us.deleteEmployee("4"); 
		Assertions.assertNull(us.retrieveEmployee("4"));
	}

	@Test
	@Order(5)
	public void testRetrieveEmploye() {
		Employee u =  us.retrieveEmployee("5"); 
		Assertions.assertEquals(5,u.getId());
	}
	@Test
	@Order(6)
	public void testLogin() {
		Employee u =  us.login("taha.jemmali@gmail.com", "12345678"); 
		Assertions.assertNull(u);
	}
}
