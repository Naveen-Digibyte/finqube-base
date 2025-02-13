package com.digibyte.midfinwealth.finqube.model;

import lombok.Data;

/**
 * @author Naveen
 *
 * History:
 * -12-01-2025 <NaveenDhanasekaran> RegisterModel
 *      - InitialVersion
 */

@Data
public class RegisterModel {
    private String userName;
    private String email;
    private String mobileNumber;
    private String password;
}
