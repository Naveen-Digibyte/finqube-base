package com.digibyte.midfinwealth.finqube.ecan.payload;

import com.digibyte.midfinwealth.finqube.ecan.enums.Country;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Data;

@Data
class TaxRecord {
	
    @JacksonXmlProperty(localName = "SEQ_NUM")
    private int seqNum;

    @JacksonXmlProperty(localName = "TAX_COUNTRY")
    private Country taxCountry;

    @JacksonXmlProperty(localName = "TAX_REF_NO")
    private String taxRefNo;

    @JacksonXmlProperty(localName = "IDENTI_TYPE")
    private String identiType;
}   