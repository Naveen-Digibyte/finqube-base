package com.digibyte.midfinwealth.finqube.ecan.payload;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Data;

@Data
class ConsentDetails {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "CONSENT_RECORD")
    private List<ConsentRecord> consentRecord;
}