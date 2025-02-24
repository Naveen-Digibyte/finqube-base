package com.digibyte.midfinwealth.finqube.transaction.service;

import com.digibyte.midfinwealth.finqube.constants.URLConstants;
import com.digibyte.midfinwealth.finqube.enums.ApiType;
import com.digibyte.midfinwealth.finqube.transaction.payload.SwapPayEezzRequest;
import com.digibyte.midfinwealth.finqube.transaction.payload.SwapPayEezzResponse;
import com.digibyte.midfinwealth.finqube.utils.MfUtilityHttpEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Naveen
 *
 * History:
 * -21-02-2025 <NaveenDhanasekaran> SwapPayEezzService
 *      - InitialVersion
 */

@Service
@RequiredArgsConstructor
public class SwapPayEezzService {
    
    private final MfUtilityHttpEntity utilityHttpEntity;
    
    public SwapPayEezzResponse swapPayEezz(SwapPayEezzRequest swapPayEezzRequest){
        try{
            return utilityHttpEntity.sendRequest(swapPayEezzRequest, ApiType.SWP_PAYEEZ, URLConstants.SWAP_PAYEEZZ_SERVICE, SwapPayEezzResponse.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
