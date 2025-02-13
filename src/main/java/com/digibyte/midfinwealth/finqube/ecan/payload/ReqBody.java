package com.digibyte.midfinwealth.finqube.ecan.payload;

import com.digibyte.midfinwealth.finqube.ecan.enums.*;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JacksonXmlRootElement(localName = "REQ_BODY")
public class ReqBody {
	
    @JacksonXmlProperty(localName = "REQ_ENT_VIA")
    private String reqEntVia;

    @JacksonXmlProperty(localName = "REQ_EVENT")
    private RequestEvent reqEvent;

    @JacksonXmlProperty(localName = "CAN")
    private String can;

    @JacksonXmlProperty(localName = "PROOF_UPLOAD_BY_CAN")
    private ConfirmationStatus proofUploadByCan;

    @JacksonXmlProperty(localName = "ENABLE_ONLINE_ACCESS_FLAG")
    private ConfirmationStatus enableOnlineAccessFlag;

    @JacksonXmlProperty(localName = "ENTITY_EMAIL_DETAILS")
    private EntityEmailDetails entityEmailDetails;

    @JacksonXmlProperty(localName = "REG_TYPE")
    private RegistrationType regType;

    @JacksonXmlProperty(localName = "HOLDING_TYPE")
    private HoldingType holdingType;

    @JacksonXmlProperty(localName = "INV_CATEGORY")
    private InvestorCategory invCategory;

    @JacksonXmlProperty(localName = "TAX_STATUS")
    private ResidentialStatus taxStatus;

    @JacksonXmlProperty(localName = "HOLDER_COUNT")
    private int holderCount;

    @JacksonXmlProperty(localName = "HOLDER_RECORDS")
    private HolderRecords holderRecords;

    @JacksonXmlProperty(localName = "BANK_DETAILS")
    private BankDetails bankDetails;

    @JacksonXmlProperty(localName = "CONSENT_DETAILS")
    private ConsentDetails consentDetails;

    @JacksonXmlProperty(localName = "NOMINEE_DETAILS")
    private NomineeDetails nomineeDetails;
    
}

