package com.digibyte.midfinwealth.finqube.transaction.service;

import com.digibyte.midfinwealth.finqube.constants.URLConstants;
import com.digibyte.midfinwealth.finqube.enums.ApiType;
import com.digibyte.midfinwealth.finqube.transaction.payload.CanFolioValidRequest;
import com.digibyte.midfinwealth.finqube.transaction.payload.CanFolioValidResponse;
import com.digibyte.midfinwealth.finqube.utils.MfUtilityHttpEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Naveen
 *
 * History:
 * -21-02-2025 <NaveenDhanasekaran> CanFolioValidService
 *      - InitialVersion
 */

@Service
@RequiredArgsConstructor
public class CanFolioValidService {
    
    private final MfUtilityHttpEntity utilityHttpEntity;
    
    public CanFolioValidResponse checkCanFolioValidation(CanFolioValidRequest canFolioValidRequest){
        try{
            return utilityHttpEntity.sendRequest(canFolioValidRequest, ApiType.CAN_FOLIO_VAL, URLConstants.CAN_FOLIO_VALIDATION, CanFolioValidResponse.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
            
    }
}
