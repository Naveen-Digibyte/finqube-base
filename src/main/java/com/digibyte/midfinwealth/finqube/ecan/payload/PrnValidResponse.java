package com.digibyte.midfinwealth.finqube.ecan.payload;

import lombok.Data;

/**
 * @author Naveen
 *
 * History:
 * -21-02-2025 <NaveenDhanasekaran> PrnValidResponse
 *      - InitialVersion
 * -24-02-2025 <NaveenDhanasekaran>
 *      - Added @Data annotaion
 *      - Changed field name PRNExistingFlag to prnExistsFlag.
 */

@Data
public class PrnValidResponse {
    private String prn;
    private String prnExistsFlag;
    private String status;
}
