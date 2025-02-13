package com.digibyte.midfinwealth.finqube.ecan.payload;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Data;

@Data
public class ReqHeader {
	
    @JacksonXmlProperty(localName = "ENTITY_ID")
    private String entityId;

    @JacksonXmlProperty(localName = "UNIQUE_ID")
    private String uniqueId;

    @JacksonXmlProperty(localName = "REQUEST_TYPE")
    private String requestType;

    @JacksonXmlProperty(localName = "LOG_USER_ID")
    private String logUserId;

    @JacksonXmlProperty(localName = "EN_ENCR_PASSWORD")
    private String enEncrPassword;

    @JacksonXmlProperty(localName = "VERSION_NO")
    private String versionNo;

    @JacksonXmlProperty(localName = "TIMESTAMP")
    private String timestamp;
    
}
