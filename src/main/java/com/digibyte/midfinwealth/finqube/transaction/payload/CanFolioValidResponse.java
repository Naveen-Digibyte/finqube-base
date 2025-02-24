package com.digibyte.midfinwealth.finqube.transaction.payload;

import lombok.Data;

/**
 * @author Naveen
 *
 * History:
 * -21-02-2025 <NaveenDhanasekaran> CanFolioValidResponse
 *      - InitialVersion
 */

@Data
public class CanFolioValidResponse {

    public String canFolioValidFlag;
    public String message;
    
}
