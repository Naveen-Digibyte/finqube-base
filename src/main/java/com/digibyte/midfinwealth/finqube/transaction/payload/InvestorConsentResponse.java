package com.digibyte.midfinwealth.finqube.transaction.payload;

import lombok.Data;

import java.util.List;

/**
 * @author Naveen
 *
 * History:
 * -21-02-2025 <NaveenDhanasekaran> InvestorConsentResponse
 *      - InitialVersion
 */

@Data
public class InvestorConsentResponse {

    public String refNo;
    public String status;
    public String statusDesc;
    public List<Object> dataSetList;
    public InvApprlink invApprlink;

    @Data
    public static class InvApprlink {
        public String priLink;
        public String joint1Link;
        public String joint2Link;
        public String poaLink;
    }

}
