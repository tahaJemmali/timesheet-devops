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

import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class UserServiceImplTest {

	@Autowired
	IUserService us;
	
	@Test
	@Order(1)
	public void testRetriveAllUsers(){
		List<User> listUsers =us.retrieveAllUsers();
		Assertions.assertEquals(0,listUsers.size());
	}
	@Test
	@Order(2)
	public void testAddUser() {
	
	    try {
	        String sDate1="25/3/1993";  
		    Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
				User u= new User("sami", "ben ali", date1, Role.CHEF_DEPARTEMENT );
				User u_saved = us.addUser(u); 
				Assertions.assertEquals(u,u_saved);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	@Order(3)
	public void testUpdateUser() { 
	    try {
	        String sDate1="25/3/1998";  
		    Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
			User u= new User("taha", "Jemmali", date1, Role.ADMINISTRATEUR );
			User u_saved = us.updateUser(u); 
			Assertions.assertNotEquals(u,u_saved);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	//	
	}

	@Test
	@Order(4)
	public void testDeleteUser() {

		us.deleteUser("4"); 
		Assertions.assertNull(us.retrieveUser("4"));
	}

	@Test
	@Order(5)
	public void testRetrieveUser() {

		User u =  us.retrieveUser("5"); 
		Assertions.assertEquals(5,u.getId());
		
	
	}
}
