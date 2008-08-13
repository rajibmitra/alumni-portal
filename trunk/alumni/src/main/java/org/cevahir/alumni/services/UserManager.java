package org.cevahir.alumni.services;

import org.cevahir.alumni.model.User;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional (readOnly=true, propagation=Propagation.REQUIRED)
public interface UserManager {
	
	/**
	  * Check if the login exists and if the password is correct. 
	  * @param login : user login
	  * @param password : user password
	  * @return true if the login exists and if the password is correct. 
	  * Otherwise, return false. 
	  */
	public boolean checkLogin (String login, String password);
	
	/**
	  * Return a User object from a given login.
	  * @param login : user login
	  * @return the corresponding user object.
	  */
	public User getUser(String login);

}
