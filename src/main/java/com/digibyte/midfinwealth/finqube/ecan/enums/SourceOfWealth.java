package com.digibyte.midfinwealth.finqube.ecan.enums;

import lombok.Getter;

/**
 * @author Naveen
 *
 * History:
 * -12-01-2025 <NaveenDhanasekaran> SourceOfWealth
 *      - InitialVersion
 */

@Getter
public enum SourceOfWealth {
    SALARY("01"),
    BUSINESS_INCOME("02"),
    GIFT("03"),
    ANCESTRAL_PROPERTY("04"),
    RENTAL_INCOME("05"),
    PRIZE_MONEY("06"),
    ROYALTY("07");

    private final String code;

    SourceOfWealth(String code) {
        this.code = code;
    }

}
