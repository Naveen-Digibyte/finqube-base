package com.digibyte.midfinwealth.finqube.transaction.payload;

import lombok.Data;

/**
 * @author Naveen
 *
 * History:
 * -21-02-2025 <NaveenDhanasekaran> InvestorConsentRequest
 *      - InitialVersion
 */

@Data
public class InvestorConsentRequest {
    private String type;
    private String refNo;
}
