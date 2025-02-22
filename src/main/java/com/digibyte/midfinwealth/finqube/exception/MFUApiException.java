package com.digibyte.midfinwealth.finqube.exception;

/**
 * @author Sid
 * 
 * History:
 * -19-02-2025 <Sid>
 *      - InitialVersion
 * -21-02-2025 <NaveenDhanasekaran>
 *      - Created single argument constaructor
 */

public class MFUApiException extends Exception {
    private static final long serialVersionUID = 1L;

    public MFUApiException(String errorCode, String errorMessage) {
        super(String.format("API Error %s: %s", errorCode, errorMessage));
    }

    public MFUApiException(String message) {
        super(message);
    }

}