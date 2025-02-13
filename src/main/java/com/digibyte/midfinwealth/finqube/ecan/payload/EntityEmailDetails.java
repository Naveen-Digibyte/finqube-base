package com.digibyte.midfinwealth.finqube.ecan.payload;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sid
 * 
 * History:
 * -08-01-2025 <Sid> UserRepo
 *      - InitialVersion
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntityEmailDetails {
	
    @JacksonXmlProperty(localName = "EMAIL_ID")
    private String emailId;
    
}