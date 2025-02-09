package com.digibyte.midfinwealth.finqube.ecan.payload;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Data;

@Data
class FATCADetail {
	
    @JacksonXmlProperty(localName = "GROSS_INCOME")
    private String grossIncome;

    @JacksonXmlProperty(localName = "NET_WORTH")
    private String netWorth;

    @JacksonXmlProperty(localName = "NET_DATE")
    private String netDate;

    @JacksonXmlProperty(localName = "KRA_ADDR_TYPE")
    private String kraAddrType;

    @JacksonXmlProperty(localName = "OCCUPATION")
    private String occupation;

    @JacksonXmlProperty(localName = "PEP")
    private String pep;

    @JacksonXmlProperty(localName = "BIRTH_CITY")
    private String birthCity;

    @JacksonXmlProperty(localName = "BIRTH_COUNTRY")
    private String birthCountry;

    @JacksonXmlProperty(localName = "CITIZENSHIP")
    private String citizenship;

    @JacksonXmlProperty(localName = "NATIONALITY")
    private String nationality;

    @JacksonXmlProperty(localName = "TAX_RES_FLAG")
    private String taxResFlag;

    @JacksonXmlProperty(localName = "TAXS_RECORDS")
    private TaxsRecords taxsRecords;
    
}
