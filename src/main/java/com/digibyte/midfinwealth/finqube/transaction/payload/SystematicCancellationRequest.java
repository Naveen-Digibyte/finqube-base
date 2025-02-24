package com.digibyte.midfinwealth.finqube.transaction.payload;

import lombok.Data;

import java.util.List;

/**
 * @author Naveen
 *
 * History:
 * -21-02-2025 <NaveenDhanasekaran> SystematicCancellationRequest
 *      - InitialVersion
 */

@Data
public class SystematicCancellationRequest {

    String txnType;
    String extGroupRefNo;
    String orderMode;
    String can;
    String reqPrntEnt;
    List<CancelSysTxnDet> cancelSysTxnDet;
    LogDtl logDtl;

    @Data
    public static class CancelSysTxnDet {
        String parentGORN;
        String parentITRN;
        String cancelReasonCode;
        String cancelReasonRemarks;
    }

    @Data
    public static class LogDtl {
        String deviceType;
        String custIpAddress;
    }
}
