package com.digibyte.midfinwealth.finqube.ecan.enums;

import lombok.Getter;

/**
 * @author Naveen
 *
 * History:
 * -12-01-2025 <NaveenDhanasekaran> NomineeVerificationType
 *      - InitialVersion
 */

@Getter
public enum NomineeVerificationType {
    PHYSICAL_FORM("P"),
    NOMINEE_2FA("E"),
    NOT_APPLICABLE("X");

    private final String code;

    NomineeVerificationType(String code) {
        this.code = code;
    }

}
