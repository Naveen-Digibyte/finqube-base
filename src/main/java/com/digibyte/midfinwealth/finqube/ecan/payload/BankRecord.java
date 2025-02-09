package com.digibyte.midfinwealth.finqube.ecan.payload;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Data;

@Data
class BankRecord {
    @JacksonXmlProperty(localName = "SEQ_NUM")
    private int seqNum;

    @JacksonXmlProperty(localName = "DEFAULT_ACC_FLAG")
    private String defaultAccFlag;

    @JacksonXmlProperty(localName = "ACCOUNT_NO")
    private String accountNo;

    @JacksonXmlProperty(localName = "ACCOUNT_TYPE")
    private String accountType;

    @JacksonXmlProperty(localName = "BANK_ID")
    private String bankId;

    @JacksonXmlProperty(localName = "MICR_CODE")
    private String micrCode;

    @JacksonXmlProperty(localName = "IFSC_CODE")
    private String ifscCode;
}
