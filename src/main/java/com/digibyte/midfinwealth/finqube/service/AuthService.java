package com.digibyte.midfinwealth.finqube.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.digibyte.midfinwealth.finqube.config.JwtService;
import com.digibyte.midfinwealth.finqube.constants.SecurityConstants;
import com.digibyte.midfinwealth.finqube.domain.User;
import com.digibyte.midfinwealth.finqube.model.AuthRequest;
import com.digibyte.midfinwealth.finqube.repo.UserRepo;

@Service
public class AuthService {

	@Autowired
	UserRepo userRepo;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtService jwtService;

	public User authenticateAndGetUserData(AuthRequest request, HttpHeaders responseHeaders) {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		} catch (Exception ex) {
			System.out.println("Exception"+ex.getMessage());
		}
		var user = userRepo.findByEmail(request.getUsername()).orElseThrow();
		var jwtToken = jwtService.generateToken(user);
		responseHeaders.set(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + jwtToken);
		return user;
	}

}
