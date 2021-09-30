package com.factorit.crypto.crypto.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.factorit.crypto.crypto.service.user.UserService_impl;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	private final static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService_impl userService;

	@RequestMapping(method = RequestMethod.GET, value = "/new", params = { "user", "password", "name", "surname" })
	public ResponseEntity<?> newUser(@RequestParam(name = "user") String user,
			@RequestParam(name = "password") String password, @RequestParam(name = "name") String name,
			@RequestParam(name = "surname") String surname) {
		try {
			return userService.newUser(user, password, name, surname);
		} catch (Exception e) {
			logger.error(e.toString());
			return new ResponseEntity<String>(new String("Ocurrio un problema."), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
