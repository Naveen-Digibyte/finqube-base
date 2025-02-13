package com.digibyte.midfinwealth.finqube.model;

import lombok.Data;

/**
 * @author Sid
 *
 * History:
 * -08-02-2025 <SiddarthNatarajan> ResourceNotFoundException
 *      - InitialVersion
 * -12-02-2025<NaveenDhanasekaren>
 *     	- changed username to email field
 */

@Data
public class AuthRequest {
	private String email;
	private String password;
}
