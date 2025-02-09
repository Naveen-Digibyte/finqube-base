package com.digibyte.midfinwealth.finqube.ecan.payload;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespBody {

    @JacksonXmlProperty(localName = "CAN")
    private String can;

    @JacksonXmlProperty(localName = "PROOF_UPLOAD_LINK")
    private String proofUploadLink;

    @JacksonXmlProperty(localName = "NOM_VER_LINK_H1")
    private String nomVerLinkH1;

    @JacksonXmlProperty(localName = "NOM_VER_LINK_H2")
    private String nomVerLinkH2;

    @JacksonXmlProperty(localName = "NOM_VER_LINK_H3")
    private String nomVerLinkH3;
}