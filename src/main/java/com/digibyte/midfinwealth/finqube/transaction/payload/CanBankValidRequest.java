package com.digibyte.midfinwealth.finqube.transaction.payload;

import lombok.Data;

/**
 * @author Naveen
 *
 * History:
 * -21-02-2025 <NaveenDhanasekaran> BankValidRequestBody
 *      - InitialVersion
 *      -Changed Class name
 */

@Data
public class CanBankValidRequest {
    private String can;
    private String accountNo;
    private String micrNo;
    private String ifscCode;
}
