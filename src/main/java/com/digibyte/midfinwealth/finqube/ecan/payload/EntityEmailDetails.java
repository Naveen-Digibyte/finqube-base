package com.digibyte.midfinwealth.finqube.ecan.payload;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Data;

@Data
class EntityEmailDetails {
	
    @JacksonXmlProperty(localName = "EMAIL_ID")
    private String emailId;
    
}