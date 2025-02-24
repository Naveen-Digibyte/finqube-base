package com.digibyte.midfinwealth.finqube.transaction.payload;

import lombok.Data;

/**
 * @author Naveen
 *
 * History:
 * -21-02-2025 <NaveenDhanasekaran> CanFolioValidRequest
 *      - InitialVersion
 */

@Data
public class CanFolioValidRequest {
    public String can;
    public String folio;
    public String checkDigit;
    public String txnType;
    public String rtaAmcCode;
}
