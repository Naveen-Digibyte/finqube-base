package com.digibyte.midfinwealth.finqube.transaction.payload;

import lombok.Data;

/**
 * @author Naveen
 *
 * History:
 * -21-02-2025 <NaveenDhanasekaran> InvestorConsentEntryResponse
 *      - InitialVersion
 */

@Data
public class InvestorConsentEntryResponse {

    public String refNo;
    public String priLink;
    public String joint1Link;
    public String joint2Link;
    public String poaLink;
    
}
