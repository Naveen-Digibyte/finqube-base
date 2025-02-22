package com.digibyte.midfinwealth.finqube.service;

import com.digibyte.midfinwealth.finqube.constants.Constants;
import com.digibyte.midfinwealth.finqube.constants.ErrorConstants;
import com.digibyte.midfinwealth.finqube.exception.AuthenticationException;
import com.digibyte.midfinwealth.finqube.model.AuthResponse;
import com.digibyte.midfinwealth.finqube.model.RegisterModel;
import com.digibyte.midfinwealth.finqube.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.digibyte.midfinwealth.finqube.config.JwtService;
import com.digibyte.midfinwealth.finqube.constants.SecurityConstants;
import com.digibyte.midfinwealth.finqube.domain.User;
import com.digibyte.midfinwealth.finqube.model.AuthRequest;
import com.digibyte.midfinwealth.finqube.repo.UserRepo;

/**
 * @author Sid
 * 
 * History:
 * -08-01-2025 <Sid> AuthService
 *      - InitialVersion
 * -12-02-2025 <NaveenDhanasekaran>
 *      - created registerNewUSer method
 */

@Service
public class AuthService {

	@Autowired
	UserRepo userRepo;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtService jwtService;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	public AuthResponse authenticateAndGetUserData(AuthRequest request, HttpHeaders responseHeaders) {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
			);
		} catch (BadCredentialsException ex) {
			throw new AuthenticationException(ErrorConstants.E_0001, HttpStatus.UNAUTHORIZED);
		} catch (Exception ex) {
			throw new AuthenticationException(ErrorConstants.E_0007, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		var user = userRepo.findByEmail(request.getEmail())
				.orElseThrow(() -> new AuthenticationException(String.format(ErrorConstants.E_0001, request.getEmail())));
		var jwtToken = jwtService.generateToken(user);
		System.out.println(jwtToken);
		responseHeaders.set(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + jwtToken);
		UserDto userDTO = new UserDto(
				user.getUserId(),
				user.getCustomerId(),
				user.getEmail(),
				user.getUsername(),
				user.getMobileNumber()
		);
		return new AuthResponse(Constants.LOGIN_SUCCESSFUL,userDTO);
	}

	public String registerNewUser(RegisterModel request) {
		if (userRepo.existsByEmail(request.getEmail())) {
			throw new AuthenticationException(ErrorConstants.E_0004);
		}
		if (userRepo.existsByUserName(request.getUserName())) {
			throw new AuthenticationException(ErrorConstants.E_0005);
		}
		if (userRepo.existsByMobileNumber(request.getMobileNumber())) {
			throw new AuthenticationException(ErrorConstants.E_0006);
		}
		long userCount = userRepo.count();
		String customerId = "FIN" + String.format("%04d", userCount + 1);
		userRepo.save(User.builder()
				.customerId(customerId)
				.userName(request.getUserName())
				.email(request.getEmail())
				.mobileNumber(request.getMobileNumber())
				.password(passwordEncoder.encode(request.getPassword()))
				.build());
		return Constants.REGISTER_SUCCESSFUL;
	}

}
