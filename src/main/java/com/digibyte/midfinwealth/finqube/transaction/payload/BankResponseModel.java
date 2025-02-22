package com.digibyte.midfinwealth.finqube.transaction.payload;

import com.digibyte.midfinwealth.finqube.model.mfUtility.MFResponseHeader;
import lombok.Data;

/**
 * @author Naveen
 *
 * History:
 * -21-02-2025 <NaveenDhanasekaran> BankResponseModel
 *      - InitialVersion
 */

@Data
public class BankResponseModel {

    private MFResponseHeader respHeader;
    private Body respBody;

    @Data
    static class Body {
        private String bankExistFlag;
    }
}
