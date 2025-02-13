package com.digibyte.midfinwealth.finqube.ecan.payload;

import com.digibyte.midfinwealth.finqube.ecan.enums.Country;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Data;

/**
 * @author Sid
 *
 * History:
 * -08-01-2025 <Sid> UserRepo
 *      - InitialVersion
 * -12-02-2025 <NaveenDhanasekaren>
 *      - changed type of birthCountry, citizenship and nationality
 */

@Data
public class FATCADetail {
	
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
    private Country birthCountry;

    @JacksonXmlProperty(localName = "CITIZENSHIP")
    private Country citizenship;

    @JacksonXmlProperty(localName = "NATIONALITY")
    private Country nationality;

    @JacksonXmlProperty(localName = "TAX_RES_FLAG")
    private String taxResFlag;

    @JacksonXmlProperty(localName = "TAXS_RECORDS")
    private TaxsRecords taxsRecords;
    
}
