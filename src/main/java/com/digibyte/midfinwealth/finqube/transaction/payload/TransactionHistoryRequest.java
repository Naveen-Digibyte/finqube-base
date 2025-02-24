package com.digibyte.midfinwealth.finqube.transaction.payload;

import lombok.Data;

/**
 * @author Naveen
 *
 * History:
 * -21-02-2025 <NaveenDhanasekaran> TransactionHistoryRequest
 *      - InitialVersion
 */

@Data
public class TransactionHistoryRequest {
    private String entGroupRefNo;
    private String mfuGorn;

}
