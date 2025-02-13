package com.digibyte.midfinwealth.finqube.ecan.payload;

import com.digibyte.midfinwealth.finqube.ecan.enums.NomineeGuardianRelation;
import com.digibyte.midfinwealth.finqube.ecan.enums.NomineeRelation;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Data;

import java.util.Date;

/**
 * @author Naveen
 *
 * History:
 * -12-01-2025 <NaveenDhanasekaran> NomineeRecord
 *      - InitialVersion
 */

@Data
public class NomineeRecord {

    @JacksonXmlProperty(localName = "SEQ_NUM")
    private int seqNum;

    @JacksonXmlProperty(localName = "NOMINEE_NAME")
    private String nomineeName;

    @JacksonXmlProperty(localName = "RELATION")
    private NomineeRelation relation;

    @JacksonXmlProperty(localName = "PERCENTAGE")
    private int percentage;

    @JacksonXmlProperty(localName = "DOB")
    private String dob;

    @JacksonXmlProperty(localName = "NOM_GURI_NAME")
    private String nomGuriName;

    @JacksonXmlProperty(localName = "NOM_GURI_REL")
    private NomineeGuardianRelation nomGuriRel;

    @JacksonXmlProperty(localName = "NOM_GURI_DOB")
    private Date nomGuriDob;

}