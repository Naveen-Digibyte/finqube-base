package com.digibyte.midfinwealth.finqube.ecan.payload;

import java.util.Date;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @author Sid
*
* History:
* -19=02-2025 <Sid> 
*      - InitialVersion
*/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespHeader {

    @JacksonXmlProperty(localName = "ENTITY_ID")
    private String entityId;

    @JacksonXmlProperty(localName = "UNIQUE_ID")
    private String uniqueId;

    @JacksonXmlProperty(localName = "REQUEST_TYPE")
    private String requestType;

    @JacksonXmlProperty(localName = "VERSION_NO")
    private String versionNo;

    @JacksonXmlProperty(localName = "TIMESTAMP")
    private Date timestamp;

    @JacksonXmlProperty(localName = "RES_CODE")
    private int resCode;

    @JacksonXmlProperty(localName = "RES_MSG")
    private String resMsg;
}