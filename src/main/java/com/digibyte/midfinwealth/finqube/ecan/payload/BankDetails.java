package com.digibyte.midfinwealth.finqube.ecan.payload;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sid
 * 
 * History:
 * -08-02-2025 <Sid> BankDetails
 *      - InitialVersion
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankDetails {
	
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "BANK_RECORD")
    private List<BankRecord> bankRecord;
    
}