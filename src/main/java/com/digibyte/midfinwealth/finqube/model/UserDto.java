package com.digibyte.midfinwealth.finqube.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Naveen
 *
 * History:
 * -12-01-2025 <NaveenDhanasekaran> UserDto
 *      - InitialVersion
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long userId;
    private String customerId;
    private String email;
    private String userName;
    private String mobileNumber;
}
