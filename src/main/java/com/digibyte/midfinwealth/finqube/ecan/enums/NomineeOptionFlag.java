package com.digibyte.midfinwealth.finqube.ecan.enums;

import lombok.Getter;

/**
 * @author Naveen
 *
 * History:
 * -12-01-2025 <NaveenDhanasekaran> NomineeOptionFlag
 *      - InitialVersion
 */

@Getter
public enum NomineeOptionFlag {
    CHECKED("Y"),
    NOT_CHECKED("N"),
    NO_NOMINATION("X");

    private final String code;

    NomineeOptionFlag(String code) {
        this.code = code;
    }
    
}

