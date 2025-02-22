package com.digibyte.midfinwealth.finqube.ecan.payload;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Data;

/**
* @author Sid
*
* History:
* -19=02-2025 <Sid> 
*      - InitialVersion
*/

@Data
class ConsentRecord {
    @JacksonXmlProperty(localName = "DATA_SET")
    private String dataSet;

    @JacksonXmlProperty(localName = "ENABLED_CONSENT")
    private String enabledConsent;
}