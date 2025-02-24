package com.digibyte.midfinwealth.finqube.transaction.payload;

import lombok.Data;

import java.util.List;

/**
 * @author Naveen
 *
 * History:
 * -21-02-2025 <NaveenDhanasekaran> SystematicCancellationResponse
 *      - InitialVersion
 */

@Data
public class SystematicCancellationResponse {
    private  RespHeader respHeader;
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
        private List<ItrnWiseErrDetail> itrnWiseErrDetail;
        private List<SecWisError> secWisErrorList;
        private OrdDtl ordDtl;

        @Data
        public static class ItrnWiseErrDetail {
            private String parentGorn;
            private String parentItrn;
            private String noOfInstallment;
            private String installmentDate;
            private String errorCode;
            private String errorMsg;
        }

        @Data
        public static class SecWisError {
            private String secName;
            private String secErrorCode;
            private String secErrorMsg;
        }

        @Data
        public static class OrdDtl {
            private String extGroupRefNo;
            private String mfuGorn;
        }
    }

}
