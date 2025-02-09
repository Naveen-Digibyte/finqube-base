package com.digibyte.midfinwealth.finqube.model;

import com.digibyte.midfinwealth.finqube.domain.User;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {
	
	private String message;

	private User userData;
}