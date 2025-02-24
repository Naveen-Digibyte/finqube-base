package com.digibyte.midfinwealth.finqube.controller;

import com.digibyte.midfinwealth.finqube.constants.Constants;
import com.digibyte.midfinwealth.finqube.model.ResponseModel;
import com.digibyte.midfinwealth.finqube.transaction.payload.InvestorConsentEntryRequest;
import com.digibyte.midfinwealth.finqube.transaction.payload.InvestorConsentRequest;
import com.digibyte.midfinwealth.finqube.transaction.service.InvestorConsentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Naveen
 *
 * History:
 * -21-02-2025 <NaveenDhanasekaran> InvestorConsentController
 *      - InitialVersion
 */

@RestController
@RequestMapping("/api/investorConsent")
@RequiredArgsConstructor
public class InvestorConsentController {
    
    private final InvestorConsentService investorConsentService;
    
    @GetMapping("/view")
    public ResponseEntity<ResponseModel> getInvestorConsentView(@RequestBody InvestorConsentRequest consentRequest){
        return ResponseEntity.ok().body(new ResponseModel(Constants.POSITIVE, null, investorConsentService.getInvestorConsentView(consentRequest)));
    }
    
    @PostMapping("/entry")
    public ResponseEntity<ResponseModel> getInvestorConsentEntry(@RequestBody InvestorConsentEntryRequest consentRequest){
        return ResponseEntity.ok().body(new ResponseModel(Constants.POSITIVE, null, investorConsentService.investorConsentEntry(consentRequest)));
    }
}
