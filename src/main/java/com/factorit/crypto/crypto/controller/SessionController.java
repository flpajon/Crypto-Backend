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

import com.factorit.crypto.crypto.service.session.SessionService_impl;

@RestController
@RequestMapping(value = "/session")
public class SessionController {

	private final static Logger logger = LoggerFactory.getLogger(SessionController.class);

	@Autowired
	private SessionService_impl sessionService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/login", params = { "user", "password" })
	public ResponseEntity<?> logIn(@RequestParam(name = "user") String user,
			@RequestParam(name = "password") String password) {
		try {
			return sessionService.logIn(user, password);
		} catch (Exception e) {
			logger.error(e.toString());
			return new ResponseEntity<String>(new String("Ocurrio un problema."), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
