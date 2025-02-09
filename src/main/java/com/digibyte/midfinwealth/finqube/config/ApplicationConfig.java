package com.digibyte.midfinwealth.finqube.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.digibyte.midfinwealth.finqube.constants.ErrorConstants;
import com.digibyte.midfinwealth.finqube.repo.UserRepo;

import lombok.RequiredArgsConstructor;

/**
* @author Sid
*
* History:
* -08-01-2025 <Sid> ApplicationConfig
*      - InitialVersion
*/

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

	@Autowired
	UserRepo userRepository;

	@Bean
	public UserDetailsService userDetailsService() {
		return email -> userRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException(ErrorConstants.E_0002));
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}