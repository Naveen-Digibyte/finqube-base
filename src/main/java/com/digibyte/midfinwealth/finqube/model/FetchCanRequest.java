package com.digibyte.midfinwealth.finqube.model;

import lombok.Data;

/**
 * @author Naveen
 *
 * History:
 * -21-02-2025 <NaveenDhanasekaran> FetchCanRequest
 *      - InitialVersion
 */

@Data
public class FetchCanRequest {
    private String panNo;
    private String resdStatus;
    private String modeOfHld;
    private String dob;
}
