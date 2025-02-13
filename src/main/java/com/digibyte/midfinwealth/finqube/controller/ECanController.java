package com.digibyte.midfinwealth.finqube.controller;

import com.digibyte.midfinwealth.finqube.constants.Constants;
import com.digibyte.midfinwealth.finqube.ecan.client.ECanRequestClientService;
import com.digibyte.midfinwealth.finqube.model.ECanRequestModel;
import com.digibyte.midfinwealth.finqube.model.ResponseModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseModel createCan(@Valid @RequestBody ECanRequestModel eCanRequestModel){
        return new ResponseModel(Constants.POSITIVE, null, eCanRequestClientService.createECanForIndividual(eCanRequestModel));
    }
}

