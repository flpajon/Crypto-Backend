package com.factorit.crypto.crypto.service.user;

import org.springframework.http.ResponseEntity;

import com.factorit.crypto.crypto.model.User;

public interface UserService {

	public User getUser(String user);
	
	public Boolean existUser(String user);
	
	public ResponseEntity<?> newUser(String user, String password, String name, String surname);
}
