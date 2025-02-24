package com.digibyte.midfinwealth.finqube.ecan.payload;

import lombok.Data;

/**
 * @author Naveen
 *
 * History:
 * -21-02-2025 <NaveenDhanasekaran> PrnValidRequest
 *      - InitialVersion
 */

@Data
public class PrnValidRequest {
    private String can;
    private String prn;
    private String mmrn;
    private String bankAccNo;
}
