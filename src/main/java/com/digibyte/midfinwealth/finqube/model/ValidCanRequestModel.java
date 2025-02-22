package com.digibyte.midfinwealth.finqube.model;

import lombok.Data;

/** @author Naveen
 *
 * History:
 * -20-02-2025 <NaveenDhanasekaren>
 *      - InitialVersion
 */ 

@Data
public class ValidCanRequestModel {
    private String can;
    private String pan;
    private String dob;
    private String emailId;
}
