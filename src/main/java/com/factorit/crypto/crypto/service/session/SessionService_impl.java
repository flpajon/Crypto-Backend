package com.factorit.crypto.crypto.service.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.factorit.crypto.crypto.dto.UserDTO;
import com.factorit.crypto.crypto.model.User;
import com.factorit.crypto.crypto.service.user.UserService_impl;

@Service
public class SessionService_impl implements SessionService {

	@Autowired
	private UserService_impl userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	//Valida que conicida el usuario y la contraseña recibida con alguna guardada en bd
	//Aclaro que simulo una autenticacion, ya que no llegue a implementar ninguna solucion de autentucacion como auth0.
	@Override
	public ResponseEntity<?> logIn(String user, String password) {
		if (userService.existUser(user)) {
			User currentUser = userService.getUser(user);
			if (passwordEncoder.matches(password,currentUser.getPassword())) {
				return new ResponseEntity<UserDTO>(new UserDTO(user, currentUser.getName(), currentUser.getSurname()),
						HttpStatus.OK);
			} else {
				return new ResponseEntity<String>(new String("La contraseña ingresada no es correcta."),
						HttpStatus.BAD_REQUEST);
			}
		}
		return new ResponseEntity<String>(new String("El usuario ingresado no existe."), HttpStatus.BAD_REQUEST);
	}

}
