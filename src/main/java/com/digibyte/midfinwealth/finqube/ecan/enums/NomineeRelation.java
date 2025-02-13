package com.digibyte.midfinwealth.finqube.ecan.enums;

import lombok.Getter;

/**
 * @author Naveen
 *
 * History:
 * -12-01-2025 <NaveenDhanasekaran> NomineeRelation
 *      - InitialVersion
 */

@Getter
public enum NomineeRelation {
    FATHER("MFU01"),
    MOTHER("MFU02"),
    COURT_APPOINTED_LEGAL_GUARDIAN("MFU03"),
    AUNT("MFU04"),
    BROTHER_IN_LAW("MFU05"),
    BROTHER("MFU06"),
    DAUGHTER("MFU07"),
    DAUGHTER_IN_LAW("MFU08"),
    FATHER_IN_LAW("MFU09"),
    GRAND_DAUGHTER("MFU10"),
    GRAND_FATHER("MFU11"),
    GRAND_MOTHER("MFU12"),
    GRAND_SON("MFU13"),
    MOTHER_IN_LAW("MFU14"),
    NEPHEW("MFU15"),
    NIECE("MFU16"),
    SISTER("MFU17"),
    SISTER_IN_LAW("MFU18"),
    SON("MFU19"),
    SON_IN_LAW("MFU20"),
    SPOUSE("MFU21"),
    UNCLE("MFU22"),
    OTHERS("MFU23");

    private final String code;

    NomineeRelation(String code) {
        this.code = code;
    }
    
}
