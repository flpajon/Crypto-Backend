package com.factorit.crypto.crypto.service.session;

import org.springframework.http.ResponseEntity;

public interface SessionService {

	public ResponseEntity<?> logIn(String user, String password);
}
