package com.digibyte.midfinwealth.finqube.ecan.payload;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Data;

/**
* @author Sid
*
* History:
* -19=02-2025 <Sid> 
*      - InitialVersion
*/

@Data
@JacksonXmlRootElement(localName = "CANIndFillEezzReq")
public class CanIndFillEezzReq {

    @JacksonXmlProperty(localName = "REQ_HEADER")
    private ReqHeader reqHeader;

    @JacksonXmlProperty(localName = "REQ_BODY")
    private ReqBody reqBody;
}

