package com.digibyte.midfinwealth.finqube.model;

import com.digibyte.midfinwealth.finqube.ecan.enums.AccountType;
import com.digibyte.midfinwealth.finqube.ecan.enums.BankProof;
import lombok.Data;

/**
 * @author Naveen
 *
 * History:
 * -13-01-2025 <NaveenDhanasekaran> ECanBankDetails
 *      - InitialVersion
 */

@Data
public class ECanBankDetails {
    private String bankName;
    private String bankAccNo;
    private AccountType accountType;
    private String micrCode;
    private String ifscCode;
    private BankProof bankProof;
    
}
