package com.digibyte.midfinwealth.finqube.ecan.enums;

import lombok.Getter;

/**
 * @author Naveen
 *
 * History:
 * -12-01-2025 <NaveenDhanasekaran> MinorHolderProof
 *      - InitialVersion
 */

@Getter
public enum MinorHolderProof {
    BirthCertificate("01"),
    RationCard("02"),
    Passport("03"),
    PanCard("04"),
    CourtOrder("05");
    
    private final String number;

    MinorHolderProof(String number){
        this.number = number;
    }

}
