package com.digibyte.midfinwealth.finqube.transaction.payload;

import lombok.Data;

/**
 * @author Naveen
 *
 * History:
 * -21-02-2025 <NaveenDhanasekaran> TransactionApprovalRequest
 *      - InitialVersion
 */

@Data
public class TransactionApprovalRequest {

    private String entGroupRefNo;
    private String mfuGorn;
    private String apprUsrPan;
    private String apprUsrIP;
    private String apprUsrLogTS;
    private String apprRejFlag;
    private String rejReason;
    
}
