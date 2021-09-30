package com.factorit.crypto.crypto.service.user;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.factorit.crypto.crypto.model.User;
import com.factorit.crypto.crypto.repository.UserRepository;

@Service
public class UserService_impl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User getUser(String user) {
		return userRepository.findByUserName(user);
	}

	@Override
	public Boolean existUser(String user) {
		return userRepository.existsById(user);
	}

	//Crea un nuevo usuario
	@Transactional
	@Override
	public ResponseEntity<?> newUser(String user, String password, String name, String surname) {
		if(!userRepository.existsById(user)) {
			User newUser = new User(user,passwordEncoder.encode(password),name,surname);
			return new ResponseEntity<User>(userRepository.save(newUser), HttpStatus.OK);
		}
		return new ResponseEntity<String>(new String("El usuario que intenta registrar ya existe."), HttpStatus.BAD_REQUEST);		
	}

	public void updateUser(User user) {
		userRepository.save(user);
		
	}

}
