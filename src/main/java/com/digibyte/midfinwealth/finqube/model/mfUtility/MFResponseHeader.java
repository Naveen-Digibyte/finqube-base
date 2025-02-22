package com.digibyte.midfinwealth.finqube.model.mfUtility;

import lombok.Data;

/** @author Naveen
 *
 * History:
 * -20-02-2025 <NaveenDhanasekaren> MFResponseHeader
 *      - InitialVersion
 */

@Data
public class MFResponseHeader {

    private String respFlag;
    private String respTs;
    private String errorCode;
    private String errorMsg;
    
}
