package com.digibyte.midfinwealth.finqube.ecan.payload;

import com.digibyte.midfinwealth.finqube.ecan.enums.AccountType;
import com.digibyte.midfinwealth.finqube.ecan.enums.BankProof;
import com.digibyte.midfinwealth.finqube.ecan.enums.ConfirmationStatus;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sid
 * 
 * History:
 * -08-01-2025 <Sid> BankRecord
 *      - InitialVersion
 * -12-02-2025 <NaveenDhanasekaran>
 *      - Changed type for defaultAccFlag and accountType
 */

/**
* @author Sid
*
* History:
* -19=02-2025 <Sid> 
*      - InitialVersion
*/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankRecord {
    @JacksonXmlProperty(localName = "SEQ_NUM")
    private int seqNum;

    @JacksonXmlProperty(localName = "DEFAULT_ACC_FLAG")
    private ConfirmationStatus defaultAccFlag;

    @JacksonXmlProperty(localName = "ACCOUNT_NO")
    private String accountNo;

    @JacksonXmlProperty(localName = "ACCOUNT_TYPE")
    private AccountType accountType;

    @JacksonXmlProperty(localName = "BANK_ID")
    private String bankId;

    @JacksonXmlProperty(localName = "MICR_CODE")
    private String micrCode;

    @JacksonXmlProperty(localName = "IFSC_CODE")
    private String ifscCode;

    @JacksonXmlProperty(localName = "PROOF")
    private BankProof proof;  
}
