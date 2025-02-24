package com.digibyte.midfinwealth.finqube.transaction.payload;

import lombok.Data;

import java.util.List;

/**
 * @author Naveen
 *
 * History:
 * -21-02-2025 <NaveenDhanasekaran> SwapPayEezzRequest
 *      - InitialVersion
 */

@Data
public class SwapPayEezzRequest {

    public String can;
    public String mfuGorn;
    public String newPRN;
    public String bnkId;
    public String micr;
    public String ifsc;
    public String accType;
    public String accNo;
    public String jointHolderFlag;
    public List<HolderDetail> holderDetail;

    @Data
    public static class HolderDetail {
        public String type;
        public String pan;
        public String ipAddr;
        public String logonTS;
    }
    
}
