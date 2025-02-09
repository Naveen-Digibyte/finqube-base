package com.digibyte.midfinwealth.finqube.ecan.payload;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "REQ_BODY")
public class ReqBody {
	
    @JacksonXmlProperty(localName = "REQ_ENT_VIA")
    private String reqEntVia;

    @JacksonXmlProperty(localName = "REQ_EVENT")
    private String reqEvent;

    @JacksonXmlProperty(localName = "CAN")
    private String can;

    @JacksonXmlProperty(localName = "PROOF_UPLOAD_BY_CAN")
    private String proofUploadByCan;

    @JacksonXmlProperty(localName = "ENABLE_ONLINE_ACCESS_FLAG")
    private String enableOnlineAccessFlag;

    @JacksonXmlProperty(localName = "ENTITY_EMAIL_DETAILS")
    private EntityEmailDetails entityEmailDetails;

    @JacksonXmlProperty(localName = "REG_TYPE")
    private String regType;

    @JacksonXmlProperty(localName = "HOLDING_TYPE")
    private String holdingType;

    @JacksonXmlProperty(localName = "INV_CATEGORY")
    private String invCategory;

    @JacksonXmlProperty(localName = "TAX_STATUS")
    private String taxStatus;

    @JacksonXmlProperty(localName = "HOLDER_COUNT")
    private int holderCount;

    @JacksonXmlProperty(localName = "HOLDER_RECORDS")
    private HolderRecords holderRecords;

    @JacksonXmlProperty(localName = "BANK_DETAILS")
    private BankDetails bankDetails;

    @JacksonXmlProperty(localName = "CONSENT_DETAILS")
    private ConsentDetails consentDetails;
    
}

