package com.digibyte.midfinwealth.finqube.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digibyte.midfinwealth.finqube.domain.User;
import com.digibyte.midfinwealth.finqube.model.AuthRequest;
import com.digibyte.midfinwealth.finqube.model.AuthResponse;
import com.digibyte.midfinwealth.finqube.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	AuthService authService;

    @PostMapping("/v1/authenticate")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
    	HttpHeaders responseHeaders = new HttpHeaders();
		User userData = authService.authenticateAndGetUserData(authRequest, responseHeaders);
		return ResponseEntity.ok().headers(responseHeaders)
				.body(new AuthResponse("Success", userData));
    }
}
