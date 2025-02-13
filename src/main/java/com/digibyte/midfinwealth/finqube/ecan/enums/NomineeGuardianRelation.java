package com.digibyte.midfinwealth.finqube.ecan.enums;

import lombok.Getter;

/**
 * @author Naveen
 *
 * History:
 * -12-01-2025 <NaveenDhanasekaran> NomineeGuardianRelation
 *      - InitialVersion
 */

@Getter
public enum NomineeGuardianRelation {
    FATHER("MFU24"),
    MOTHER("MFU25"),
    COURT_APPOINTED_LEGAL_GUARDIAN("MFU26"),
    AUNT("MFU27"),
    BROTHER_IN_LAW("MFU28"),
    BROTHER("MFU29"),
    DAUGHTER("MFU30"),
    DAUGHTER_IN_LAW("MFU31"),
    FATHER_IN_LAW("MFU32"),
    GRAND_DAUGHTER("MFU33"),
    GRAND_FATHER("MFU34"),
    GRAND_MOTHER("MFU35"),
    GRAND_SON("MFU36"),
    MOTHER_IN_LAW("MFU37"),
    NEPHEW("MFU38"),
    NIECE("MFU39"),
    SISTER("MFU40"),
    SISTER_IN_LAW("MFU41"),
    SON("MFU42"),
    SON_IN_LAW("MFU43"),
    SPOUSE("MFU44"),
    UNCLE("MFU45"),
    OTHERS("MFU46");

    private final String code;

    NomineeGuardianRelation(String code) {
        this.code = code;
    }

}
