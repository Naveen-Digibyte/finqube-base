package com.digibyte.midfinwealth.finqube.ecan.enums;

import lombok.Getter;

/**
 * @author Naveen
 *
 * History:
 * -12-01-2025 <NaveenDhanasekaran> BankProof
 *      - InitialVersion
 */

@Getter
public enum BankProof {
    PassBook("14"),
    Statement("15"),
    Cheque("77"),
    BankLetter("78");

    private final String code;

    BankProof(String code) {
        this.code = code;
    }
}
