package com.digibyte.midfinwealth.finqube.ecan.payload;

import com.digibyte.midfinwealth.finqube.ecan.enums.ConfirmationStatus;
import com.digibyte.midfinwealth.finqube.ecan.enums.HolderType;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sid
 *
 * History:
 * -08-01-2025 <Sid> UserRepo
 *      - InitialVersion
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HolderRecord {
	
    @JacksonXmlProperty(localName = "HOLDER_TYPE")
    private HolderType holderType;

    @JacksonXmlProperty(localName = "NAME")
    private String name;

    @JacksonXmlProperty(localName = "DOB")
    private String dob;

    @JacksonXmlProperty(localName = "PAN_EXEMPT_FLAG")
    private ConfirmationStatus panExemptFlag;

    @JacksonXmlProperty(localName = "PAN_PEKRN_NO")
    private String panPekrnNo;

    @JacksonXmlProperty(localName = "CONTACT_DETAIL")
    private ContactDetail contactDetail;

    @JacksonXmlProperty(localName = "FATCA_DETAIL")
    private FATCADetail fatcaDetail;
    
}