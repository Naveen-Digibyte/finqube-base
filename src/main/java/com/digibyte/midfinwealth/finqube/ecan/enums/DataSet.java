package com.digibyte.midfinwealth.finqube.ecan.enums;

import lombok.Getter;

/**
 * @author Naveen
 *
 * History:
 * -12-01-2025 <NaveenDhanasekaran> DataSet
 *      - InitialVersion
 */

@Getter
public enum DataSet {
    CAN_DATA_SET("CD"),
    PAYEEZZ_DATA("PD"),
    MAPPED_FOLIO("MF"),
    HOLDING_DATA("HD");

    private final String code;

    DataSet(String code) {
        this.code = code;
    }

}
