package com.digibyte.midfinwealth.finqube.transaction.service;

import com.digibyte.midfinwealth.finqube.constants.URLConstants;
import com.digibyte.midfinwealth.finqube.enums.ApiType;
import com.digibyte.midfinwealth.finqube.transaction.payload.CanBankValidRequest;
import com.digibyte.midfinwealth.finqube.transaction.payload.CanBankValidResponse;
import com.digibyte.midfinwealth.finqube.utils.MfUtilityHttpEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Naveen
 * 
 * History:
 * -21-02-2025 <NaveenDhanasekaran> BankValidationService
 *      - InitialVersion
 * -24-02-2025 <NaveenDhanasekaran>
 *      - Modified checkCanBankValidation method
 */

@Service
@RequiredArgsConstructor
public class BankValidationService {

    private final MfUtilityHttpEntity request;
    
    public boolean checkCanBankValidation(CanBankValidRequest bankValidRequestBody) {
        try {
            request.sendRequest(bankValidRequestBody, ApiType.CAN_BNK_VAL, URLConstants.VALID_CAN_BANK, CanBankValidResponse.class);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}