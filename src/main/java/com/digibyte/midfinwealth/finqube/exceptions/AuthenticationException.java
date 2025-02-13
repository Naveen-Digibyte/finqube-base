package com.digibyte.midfinwealth.finqube.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @author Naveen
 *
 * History:
 * -12-01-2025 <NaveenDhanasekaran> AuthenticationException
 *      - InitialVersion
 */

@Getter
public class AuthenticationException extends RuntimeException{
    
    private HttpStatus status;

    public AuthenticationException(String message) {
        super(message);
    }
    public AuthenticationException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

}
