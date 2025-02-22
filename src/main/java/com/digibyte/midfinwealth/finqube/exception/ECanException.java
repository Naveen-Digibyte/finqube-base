package com.digibyte.midfinwealth.finqube.exception;

/**
 * @author Naveen
 *
 * History:
 * -13-01-2025 <NaveenDhanasekaran> ECanException
 *      - InitialVersion
 */

public class ECanException extends RuntimeException{
	
    private static final long serialVersionUID = 1L;

	public ECanException(String  message){
        super(message);
    }
}
