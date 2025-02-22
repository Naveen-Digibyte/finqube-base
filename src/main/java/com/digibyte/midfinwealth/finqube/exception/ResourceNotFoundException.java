package com.digibyte.midfinwealth.finqube.exception;

/**
 * @author Naveen
 *
 * History:
 * -13-01-2025 <NaveenDhanasekaran> ResourceNotFoundException
 *      - InitialVersion
 */

public class ResourceNotFoundException extends RuntimeException {
    
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message) {
        super(message);
    }
}
