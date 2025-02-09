package com.digibyte.midfinwealth.finqube.ecan.payload;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Data;

@Data
class HolderRecords {
	
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "HOLDER_RECORD")
    private List<HolderRecord> holderRecord;
    
}
