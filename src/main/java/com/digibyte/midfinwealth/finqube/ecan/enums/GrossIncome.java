package com.digibyte.midfinwealth.finqube.ecan.enums;

import lombok.Getter;

/**
 * @author Naveen
 *
 * History:
 * -12-01-2025 <NaveenDhanasekaran> GrossIncome
 *      - InitialVersion
 */

@Getter
public enum GrossIncome {
    BELOW_1_LAC("01"),
    ONE_TO_FIVE_LAC("02"),
    FIVE_TO_TEN_LAC("03"),
    TEN_TO_TWENTY_FIVE_LAC("04"),
    TWENTY_FIVE_LAC_TO_ONE_CR("05"),
    GREATER_THAN_ONE_CR("06");

    private final String code;

    GrossIncome(String code) {
        this.code = code;
    }
    
}
