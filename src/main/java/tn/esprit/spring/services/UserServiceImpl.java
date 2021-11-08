package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;

	private static final Logger l=LogManager.getLogger(UserServiceImpl.class);
	
	@Override
	public List<User> retrieveAllUsers() { 
		List<User> users = null; 
		try {
	
			l.info("In retrieveAllUser() ");
			users = (List<User>) userRepository.findAll();  
			for (User user : users) {
				l.debug("user +++: "+user);
			} 
			l.info("Out of retrieveAllUser() with success ");
		}catch (Exception e) {
			l.error("Error in  retrieveAllUser() with Error: "+ e);
		}

		return users;
	}


	@Override
	public User addUser(User u) {
		l.info("In addUser() : ");
		User u_saved = userRepository.save(u); 
		l.info("Out of addUser() : saved user: "+u_saved);
		return u_saved; 
	}

	@Override 
	public User updateUser(User u) { 
		l.info("In updateUser() : ");
		User u_saved = userRepository.save(u); 
		l.info("Out of updateUser() : updated user: "+u_saved);
		return u_saved; 
	}

	@Override
	public int deleteUser(String id) {
		try{
			l.info("In deleteUser() : ");
			userRepository.deleteById(Long.parseLong(id)); 
			l.info("Out of deleteUser() : deleted user id : "+id);
			return 1;
		}catch (Exception e){
			return -1;
		}
	
	}

	@Override
	public User retrieveUser(String id) {
		l.info("In retrieveUser() : ");
		//User u =  userRepository.findById(Long.parseLong(id)).orElse(null);
		User u =  userRepository.findById(Long.parseLong(id)).get(); 
		l.info("Out of retrieveUser() : found user : "+u);
		return u; 
	}

}
