package com.digibyte.midfinwealth.finqube.exceptions;

/**
 * @author Naveen
 *
 * History:
 * -13-01-2025 <NaveenDhanasekaran> ResourceNotFoundException
 *      - InitialVersion
 */

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
