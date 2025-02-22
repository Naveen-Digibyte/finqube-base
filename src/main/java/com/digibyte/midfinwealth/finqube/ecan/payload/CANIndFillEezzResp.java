package com.digibyte.midfinwealth.finqube.ecan.payload;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
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
@JacksonXmlRootElement(localName = "CANIndFillEezzResp")
public class CANIndFillEezzResp {

    @JacksonXmlProperty(localName = "RESP_HEADER")
    private RespHeader respHeader;

    @JacksonXmlProperty(localName = "RESP_BODY")
    private RespBody respBody;
}

