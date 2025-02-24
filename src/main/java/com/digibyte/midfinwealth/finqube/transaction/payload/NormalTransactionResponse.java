package com.digibyte.midfinwealth.finqube.transaction.payload;

import lombok.Data;

import java.util.List;

/**
 * @author Naveen
 *
 * History:
 * -21-02-2025 <NaveenDhanasekaran> NormalTransactionResponse
 *      - InitialVersion
 */

@Data
public class NormalTransactionResponse {

    private RespHeader respHeader;
    private RespBody respBody;

    @Data
    public static class RespHeader {
        private String respTs;
        private String respFlag;
        private String errorCode;
        private String errorMsg;
    }

    @Data
    public static class RespBody {
        private String ordCreatedFlag;
        private List<SecWisError> secWisErrorList;
        private OrdDtl ordDtl;
    }

    @Data
    public static class SecWisError {
        private String secName;
        private String secErrorCode;
        private String secErrorMsg;
    }

    @Data
    public static class OrdDtl {
        private String entGroupRefNo;
        private String mfuGorn;
        private String orderstatus;
        private String virtualAccNo;
        private String virtAccIfsc;
        private String appLinkPri;
        private String appLinkH1;
        private String appLinkH2;
        private String appLinkPOA;
        private String paymentLink;
        private List<ItrnWiseStatus> itrnWiseStatus;
    }

    @Data
    public static class ItrnWiseStatus {
        private String entUnqItrn;
        private String mfuItrn;
        private String itrnOrdStatus;
        private String errorCode;
        private String errorMsg;
    }
}
