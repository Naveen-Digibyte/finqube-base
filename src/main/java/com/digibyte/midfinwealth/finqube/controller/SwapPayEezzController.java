package com.digibyte.midfinwealth.finqube.controller;

import com.digibyte.midfinwealth.finqube.constants.Constants;
import com.digibyte.midfinwealth.finqube.model.ResponseModel;
import com.digibyte.midfinwealth.finqube.transaction.payload.SwapPayEezzRequest;
import com.digibyte.midfinwealth.finqube.transaction.service.SwapPayEezzService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Naveen
 *
 * History:
 * -21-02-2025 <NaveenDhanasekaran> SwapPayEezzController
 *      - InitialVersion
 */

@RestController
@RequestMapping("/api/pay")
@RequiredArgsConstructor
public class SwapPayEezzController {
    
    private final SwapPayEezzService swapPayEezzService;
    
    @PostMapping("/v1")
    public ResponseEntity<ResponseModel > swapPay(@RequestBody SwapPayEezzRequest swapPayEezzRequest){
        return ResponseEntity.ok().body(new ResponseModel(Constants.POSITIVE, null, swapPayEezzService.swapPayEezz(swapPayEezzRequest)));
    }
}
