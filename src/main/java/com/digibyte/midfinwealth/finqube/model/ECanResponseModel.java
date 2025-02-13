package com.digibyte.midfinwealth.finqube.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Naveen
 *
 * History:
 * -13-01-2025 <NaveenDhanasekaran> ECanResponseModel
 *      - InitialVersion
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ECanResponseModel {
    private RespHeader respHeader;

    private RespBody respBody;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RespHeader {
        private String entityId;

        private String uniqueId;

        private String requestType;

        private String versionNo;

        private String timestamp;

        private int resCode;

        private String resMsg;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RespBody {
        private String can;

        private String proofUploadLink;

        private String nomVerLinkH1;

        private String nomVerLinkH2;

        private String nomVerLinkH3;
    }
}
