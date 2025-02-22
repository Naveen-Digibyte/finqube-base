package com.digibyte.midfinwealth.finqube.ecan.payload;

import com.digibyte.midfinwealth.finqube.ecan.enums.NomineeDeclaration;
import com.digibyte.midfinwealth.finqube.ecan.enums.NomineeOptionFlag;
import com.digibyte.midfinwealth.finqube.ecan.enums.NomineeVerificationType;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Data;

import java.util.List;

/**
 * @author Naveen
 *
 * History:
 * -12-01-2025 <NaveenDhanasekaran> NomineeDetails
 *      - InitialVersion
 */

@Data
public class NomineeDetails {

    @JacksonXmlProperty(localName = "NOM_DECL_LVL")
    private NomineeDeclaration nomDeclLvl;
    
    @JacksonXmlProperty(localName = "NOMIN_OPT_FLAG")
    private String nominOptFlag;
    
    @JacksonXmlProperty(localName = "NOM_VERIFY_TYPE")
    private String nomVerifyType;
    
    @JacksonXmlElementWrapper(localName = "NOMINEES_RECORDS")
    @JacksonXmlProperty(localName = "NOMINEE_RECORD")
    private List<NomineeRecord> nomineesRecords;
}
