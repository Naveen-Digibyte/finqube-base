package com.digibyte.midfinwealth.finqube.model.mfUtility;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

/** @author Naveen
 *
 * History:
 * -20-02-2025 <NaveenDhanasekaren> MFUtilityRequest
 *      - InitialVersion
 */

@Data
@Builder
public class MFUtilityRequest {

	@JsonProperty("reqHeader")
    private ReqHeader reqHeader;
    
    @JsonProperty("reqBody")
    private ReqBody reqBody;

    @Data
    @Builder
    public static class ReqHeader {
        private String entityId;
        private String version;
        private String reqTS;
        private String apiType;
        private String userId;
        private String encryptPwd;
        private String uniqueId;
    }

    @Data
    @Builder
    public static class ReqBody {
        private String data;
    }
}