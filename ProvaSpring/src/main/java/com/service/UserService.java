package com.service;

import com.model.Utente;

public interface UserService {
	
	public Utente getUser(String Username);
	public void saveUser(Utente user);
	
	
	
	

}
