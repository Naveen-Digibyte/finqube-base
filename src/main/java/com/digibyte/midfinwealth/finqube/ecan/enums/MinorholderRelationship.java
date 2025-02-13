package com.digibyte.midfinwealth.finqube.ecan.enums;

import lombok.Getter;

/**
 * @author Naveen
 *
 * History:
 * -12-01-2025 <NaveenDhanasekaran> MinorholderRelationship
 *      - InitialVersion
 */

@Getter
public enum MinorholderRelationship {
    Mother("01"), Father("02"), Guardian("03");

    private final String number;
    MinorholderRelationship(String number) {
        this.number = number;
    }

}
