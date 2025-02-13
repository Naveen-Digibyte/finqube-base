package com.digibyte.midfinwealth.finqube.ecan.enums;

import lombok.Getter;

/**
 * @author Naveen
 *
 * History:
 * -12-01-2025 <NaveenDhanasekaran> IdentityType
 *      - InitialVersion
 */

@Getter
public enum IdentityType {
    PASSPORT("A"),
    ELECTION_ID_CARD("B"),
    PAN_CARD("C"),
    ID_CARD("D"),
    DRIVING_LICENSE("E"),
    UIDAI_AADHAR_LETTER("G"),
    NREGA_JOB_CARD("H"),
    OTHERS("O"),
    TIN("T"),
    NOT_CATEGORIZED("X");

    private final String code;

    IdentityType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
