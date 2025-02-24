package com.digibyte.midfinwealth.finqube.transaction.payload;

import lombok.Data;

import java.util.List;

/**
 * @author Naveen
 *
 * History:
 * -21-02-2025 <NaveenDhanasekaran> InvestorConsentEntryRequest
 *      - InitialVersion
 */

@Data
public class InvestorConsentEntryRequest {

    public String can;
    public String pan;
    public String mobNo;
    public List<DataSetItem> dataSetArr;

    @Data
    public static class DataSetItem {
        public String dataSetKey;
    }
    
}
