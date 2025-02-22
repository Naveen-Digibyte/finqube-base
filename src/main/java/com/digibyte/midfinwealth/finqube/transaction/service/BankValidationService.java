package com.digibyte.midfinwealth.finqube.transaction.service;

import com.digibyte.midfinwealth.finqube.constants.URLConstants;
import com.digibyte.midfinwealth.finqube.enums.ApiType;
import com.digibyte.midfinwealth.finqube.exception.MFUApiException;
import com.digibyte.midfinwealth.finqube.transaction.payload.BankResponseModel;
import com.digibyte.midfinwealth.finqube.transaction.payload.BankValidRequestBody;
import com.digibyte.midfinwealth.finqube.utils.MfUtilityHttpEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author Naveen
 *
 * History:
 * -21-02-2025 <NaveenDhanasekaran> BankValidationService
 *      - InitialVersion
 */

@Service
@RequiredArgsConstructor
public class BankValidationService {

    private final MfUtilityHttpEntity request;


    public boolean checkCanBankVlidation(BankValidRequestBody bankValidRequestBody) throws MFUApiException {
        getStringToResponse(request.getResponse(bankValidRequestBody, ApiType.CAN_BNK_VAL, URLConstants.VALID_CAN_BANK));
        return true;
    }

    public void getStringToResponse(String string) throws MFUApiException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            BankResponseModel responseModel = objectMapper.readValue(string, BankResponseModel.class);
            if (Objects.equals(responseModel.getRespHeader().getRespFlag(), "F")) {
                throw new MFUApiException(responseModel.getRespHeader().getErrorCode(), responseModel.getRespHeader().getErrorMsg());
            }
        } catch (Exception e) {
            throw new MFUApiException(e.getMessage());
        }

    }
}
