package com.digibyte.midfinwealth.finqube.ecan.enums;

import lombok.Getter;

/**
 * @author Naveen
 *
 * History:
 * -12-01-2025 <NaveenDhanasekaran> Occupation
 *      - InitialVersion
 */

@Getter
public enum Occupation {
    PRIVATE_SECTOR_SERVICE("01"),
    PUBLIC_SECTOR("02"),
    BUSINESS("03"),
    PROFESSIONAL("04"),
    AGRICULTURIST("05"),
    RETIRED("06"),
    HOUSEWIFE("07"),
    STUDENT("08"),
    FOREX_DEALER("09"),
    GOVERNMENT_SERVICE("10"),
    OTHERS("99"),
    DOCTOR("11");

    private final String code;

    Occupation(String code) {
        this.code = code;
    }

}
