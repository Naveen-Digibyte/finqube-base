package com.digibyte.midfinwealth.finqube.ecan.payload;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Data;

@Data
class ConsentRecord {
    @JacksonXmlProperty(localName = "DATA_SET")
    private String dataSet;

    @JacksonXmlProperty(localName = "ENABLED_CONSENT")
    private String enabledConsent;
}