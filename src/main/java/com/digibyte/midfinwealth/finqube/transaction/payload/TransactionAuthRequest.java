package com.digibyte.midfinwealth.finqube.transaction.payload;

import lombok.Data;

/**
 * @author Naveen
 *
 * History:
 * -21-02-2025 <NaveenDhanasekaran> TransactionAuthRequest
 *      - InitialVersion
 */

@Data
public class TransactionAuthRequest {
    String entGroupRefNo;
    String mfuGorn;
}
