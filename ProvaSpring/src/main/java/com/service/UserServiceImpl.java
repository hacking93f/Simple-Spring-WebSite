package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.model.Utente;
import com.repository.UtentiRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UtentiRepository utentiRepo;

	@Override
	public Utente getUser(String username) {
		// TODO Auto-generated method stub
		Utente u = utentiRepo.getOne(username);
		 return u;
	}

	@Override
	public void saveUser(Utente user) {
		// TODO Auto-generated method stub
		utentiRepo.save(user);
	}
	
	

	

}
