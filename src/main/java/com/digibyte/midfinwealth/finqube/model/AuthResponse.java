package com.digibyte.midfinwealth.finqube.model;

import com.digibyte.midfinwealth.finqube.domain.User;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Sid
 *
 * History:
 * -08-01-2025 <Siddarth Natarajan> AuthResponse
 *      - InitialVersion
 * -12-02-2025 <NaveenDhanasekaran>
 *     	- Changed USer to USerDto type for field userData
 */

@Data
@AllArgsConstructor
public class AuthResponse {
	
	private String message;

	private UserDto userData;
}