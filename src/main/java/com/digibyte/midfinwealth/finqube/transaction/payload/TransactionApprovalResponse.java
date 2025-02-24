package com.digibyte.midfinwealth.finqube.transaction.payload;

import lombok.Data;

/**
 * @author Naveen
 *
 * History:
 * -21-02-2025 <NaveenDhanasekaran> TransactionApprovalResponse
 *      - InitialVersion
 */

@Data
public class TransactionApprovalResponse {
    
    private String orderStatus;
}
