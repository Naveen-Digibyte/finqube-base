package com.digibyte.midfinwealth.finqube.ecan.payload;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Data;

@Data
class HolderRecord {
	
    @JacksonXmlProperty(localName = "HOLDER_TYPE")
    private String holderType;

    @JacksonXmlProperty(localName = "NAME")
    private String name;

    @JacksonXmlProperty(localName = "DOB")
    private String dob;

    @JacksonXmlProperty(localName = "PAN_EXEMPT_FLAG")
    private String panExemptFlag;

    @JacksonXmlProperty(localName = "PAN_PEKRN_NO")
    private String panPekrnNo;

    @JacksonXmlProperty(localName = "CONTACT_DETAIL")
    private ContactDetail contactDetail;

    @JacksonXmlProperty(localName = "FATCA_DETAIL")
    private FATCADetail fatcaDetail;
    
}