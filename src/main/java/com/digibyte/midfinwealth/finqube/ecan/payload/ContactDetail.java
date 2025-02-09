package com.digibyte.midfinwealth.finqube.ecan.payload;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Data;

@Data
class ContactDetail {
	
    @JacksonXmlProperty(localName = "PRI_MOB_NO")
    private String priMobNo;

    @JacksonXmlProperty(localName = "PRI_MOB_BELONGSTO")
    private String priMobBelongsTo;

    @JacksonXmlProperty(localName = "PRI_EMAIL")
    private String priEmail;

    @JacksonXmlProperty(localName = "PRI_EMAIL_BELONGSTO")
    private String priEmailBelongsTo;

    @JacksonXmlProperty(localName = "PRI_MOB_VER_FLAG")
    private String priMobVerFlag;

    @JacksonXmlProperty(localName = "PRI_EMAIL_VER_FLAG")
    private String priEmailVerFlag;

    @JacksonXmlProperty(localName = "PRI_MOB_IP_ADDR")
    private String priMobIpAddr;

    @JacksonXmlProperty(localName = "PRI_EMAIL_IP_ADDR")
    private String priEmailIpAddr;

    @JacksonXmlProperty(localName = "PRI_MOB_VER_TS")
    private String priMobVerTs;

    @JacksonXmlProperty(localName = "PRI_EMAIL_VER_TS")
    private String priEmailVerTs;
    
}