package com.digibyte.midfinwealth.finqube.controller;

import com.digibyte.midfinwealth.finqube.ecan.payload.PrnValidRequest;
import com.digibyte.midfinwealth.finqube.model.FetchCanRequest;
import com.digibyte.midfinwealth.finqube.model.ValidCanRequestModel;
import com.digibyte.midfinwealth.finqube.transaction.payload.CanFolioValidRequest;
import com.digibyte.midfinwealth.finqube.transaction.service.CanFolioValidService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.digibyte.midfinwealth.finqube.constants.Constants;
import com.digibyte.midfinwealth.finqube.ecan.service.ECanRequestClientService;
import com.digibyte.midfinwealth.finqube.model.ECanRequestModel;
import com.digibyte.midfinwealth.finqube.model.ResponseModel;

import jakarta.validation.Valid;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * @author Sid, Naveen
 *
 * History:
 * -08-01-2025 <Sid> SecurityConstants
 *      - InitialVersion
 * -12-02-2025 <NaveenDhanasekaran>
 *     	- Removed submit api and added new method to create.
 * -21-02-2025 <NaveenDhanasekaran>
 *      - Added getCanDetails, getValidPrn and getCanFolio
 */

@RestController
@RequestMapping("/api/can")
@RequiredArgsConstructor
public class ECanController {

	private final ECanRequestClientService eCanRequestClientService;
    private final CanFolioValidService canFolioValidService;
    
    @PostMapping("/create")
    public ResponseModel createCan(@Valid @RequestBody ECanRequestModel eCanRequestModel) throws InvalidAlgorithmParameterException, NoSuchPaddingException, UnsupportedEncodingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, NoSuchProviderException, InvalidKeyException {
        return new ResponseModel(Constants.POSITIVE, null, eCanRequestClientService.createECanForIndividual(eCanRequestModel));
    }
	
	@GetMapping(value = "/validate")
    public ResponseEntity<ResponseModel> validateCan(@RequestBody ValidCanRequestModel validCanRequestModel) {
        return ResponseEntity.ok().body(new ResponseModel(Constants.POSITIVE, null, eCanRequestClientService.validateECan(validCanRequestModel)));
    }
    
    @GetMapping("/fetch")
    public ResponseEntity<ResponseModel> getCanDetails(@RequestBody FetchCanRequest fetchCanRequest){
        return ResponseEntity.ok().body(new ResponseModel(Constants.POSITIVE,null, eCanRequestClientService.fetchCan(fetchCanRequest)));
    }
    
    @GetMapping("/prn/validate")
    public ResponseEntity<ResponseModel> getValidPrn(@RequestBody PrnValidRequest prnValidRequest){
        return ResponseEntity.ok().body(new ResponseModel(Constants.POSITIVE, null, eCanRequestClientService.validPRN(prnValidRequest)));
    }

    @GetMapping("/folio/validate")
    public ResponseEntity<ResponseModel> getCanFolio(@RequestBody CanFolioValidRequest canFolioValidRequest){
        return ResponseEntity.ok().body(new ResponseModel(Constants.POSITIVE, null, canFolioValidService.checkCanFolioValidation(canFolioValidRequest)));
    }

}

