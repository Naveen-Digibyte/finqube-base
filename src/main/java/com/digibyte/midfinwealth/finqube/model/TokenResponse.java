package com.digibyte.midfinwealth.finqube.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
* @author Sid
*
* History:
* -19=02-2025 <Sid> 
*      - InitialVersion
*/

@Data
@AllArgsConstructor
public class TokenResponse {
	
    private String accessToken;
    private String tokenType;
    private int expiresIn;
    
}