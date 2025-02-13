package com.digibyte.midfinwealth.finqube.ecan.enums;

import lombok.Getter;

/**
 * @author Naveen
 *
 * History:
 * -12-01-2025 <NaveenDhanasekaran> PepStatus
 *      - InitialVersion
 */

@Getter
public enum PepStatus {
    PEP("PEP"),
    RPEP("RPEP"),
    NA("NA");

    private final String code;

    PepStatus(String code) {
        this.code = code;
    }

}
