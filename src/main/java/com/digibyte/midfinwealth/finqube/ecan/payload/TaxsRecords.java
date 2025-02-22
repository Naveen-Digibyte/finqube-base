package com.digibyte.midfinwealth.finqube.ecan.payload;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
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
class TaxsRecords {
	
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "TAX_RECORD")
    private List<TaxRecord> taxRecord;
    
}