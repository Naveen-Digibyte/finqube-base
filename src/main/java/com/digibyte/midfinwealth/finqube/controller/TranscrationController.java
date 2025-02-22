package com.digibyte.midfinwealth.finqube.controller;

import com.digibyte.midfinwealth.finqube.constants.Constants;
import com.digibyte.midfinwealth.finqube.exception.MFUApiException;
import com.digibyte.midfinwealth.finqube.model.ResponseModel;
import com.digibyte.midfinwealth.finqube.transaction.payload.BankValidRequestBody;
import com.digibyte.midfinwealth.finqube.transaction.service.BankValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Naveen
 *
 * History:
 * -21-02-2025 <NaveenDhanasekaran>
 *     	- InitialVersion
 */

@RestController
@RequestMapping("/api/trans")
@RequiredArgsConstructor
public class TranscrationController {
    
    private final BankValidationService bankValidationService;
    
    @GetMapping("/check/bank")
    public ResponseEntity<ResponseModel> checkCanBank(@RequestBody BankValidRequestBody bankValidRequestBody) throws MFUApiException {
        return ResponseEntity.ok().body(new ResponseModel(Constants.POSITIVE,null, bankValidationService.checkCanBankVlidation(bankValidRequestBody)));
    }
}
