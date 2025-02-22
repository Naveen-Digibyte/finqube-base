package com.digibyte.midfinwealth.finqube.controller;

import com.digibyte.midfinwealth.finqube.model.ValidCanRequestModel;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
 */

@RestController
@RequestMapping("/api/can")
public class ECanController {

	@Autowired
	private ECanRequestClientService eCanRequestClientService;
    
    @PostMapping("/create")
    public ResponseModel createCan(@Valid @RequestBody ECanRequestModel eCanRequestModel) throws InvalidAlgorithmParameterException, NoSuchPaddingException, UnsupportedEncodingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, NoSuchProviderException, InvalidKeyException {
        return new ResponseModel(Constants.POSITIVE, null, eCanRequestClientService.createECanForIndividual(eCanRequestModel));
    }
	
	@GetMapping(value = "/validate")
    public ResponseEntity<ResponseModel> validateCan(@RequestBody ValidCanRequestModel validCanRequestModel) {
        return ResponseEntity.ok().body(new ResponseModel(Constants.POSITIVE, null, eCanRequestClientService.validateECan(validCanRequestModel)));
    }
}

