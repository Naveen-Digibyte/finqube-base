package com.digibyte.midfinwealth.finqube.controller;

import com.digibyte.midfinwealth.finqube.constants.Constants;
import com.digibyte.midfinwealth.finqube.model.RegisterModel;
import com.digibyte.midfinwealth.finqube.model.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digibyte.midfinwealth.finqube.model.AuthRequest;
import com.digibyte.midfinwealth.finqube.service.AuthService;

 /** @author Sid
 *
 * History:
 * -08-01-2025 <Sid> AuthController
 *      - InitialVersion
 * -12-02-2025 <NaveenDhanasekaran>
 *     	- Added Registered method
 */

@RestController
@RequestMapping("/api/auth/v1")
public class AuthController {
	
	@Autowired
	private AuthService authService;

    @PostMapping("/authenticate")
    public ResponseEntity<ResponseModel> login(@RequestBody AuthRequest authRequest) {
    	HttpHeaders responseHeaders = new HttpHeaders();
		return ResponseEntity.ok().headers(responseHeaders)
				.body(new ResponseModel(Constants.POSITIVE, null, authService.authenticateAndGetUserData(authRequest, responseHeaders)));
    }
	
	@PostMapping("/register")
	public ResponseEntity<ResponseModel> register(@RequestBody RegisterModel registerModel){
		return ResponseEntity.ok().body(new ResponseModel(Constants.POSITIVE, authService.registerNewUser(registerModel), null ));
	}
}
