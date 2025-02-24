package com.digibyte.midfinwealth.finqube.transaction.service;

import com.digibyte.midfinwealth.finqube.constants.URLConstants;
import com.digibyte.midfinwealth.finqube.enums.ApiType;
import com.digibyte.midfinwealth.finqube.transaction.payload.InvestorConsentEntryRequest;
import com.digibyte.midfinwealth.finqube.transaction.payload.InvestorConsentEntryResponse;
import com.digibyte.midfinwealth.finqube.transaction.payload.InvestorConsentRequest;
import com.digibyte.midfinwealth.finqube.transaction.payload.InvestorConsentResponse;
import com.digibyte.midfinwealth.finqube.utils.MfUtilityHttpEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Naveen
 *
 * History:
 * -21-02-2025 <NaveenDhanasekaran> InvestorConsentService
 *      - InitialVersion
 */

@Service
@RequiredArgsConstructor
public class InvestorConsentService {
    
    private final MfUtilityHttpEntity utilityHttpEntity;
    
    public InvestorConsentResponse getInvestorConsentView(InvestorConsentRequest consentRequest){
        try{
            return utilityHttpEntity.sendRequest(consentRequest, ApiType.INV_CON_VIEW, URLConstants.INVESTOR_CONSENT_VIEW, InvestorConsentResponse.class);
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public InvestorConsentEntryResponse investorConsentEntry(InvestorConsentEntryRequest investorConsentEntryRequest){
        try{
            return utilityHttpEntity.sendRequest(investorConsentEntryRequest, ApiType.INV_CON_ENTRY, URLConstants.INVESTOR_CONSENT_ENTRY, InvestorConsentEntryResponse.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
