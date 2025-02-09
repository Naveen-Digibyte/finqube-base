package com.digibyte.midfinwealth.finqube.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digibyte.midfinwealth.finqube.ecan.client.ECanRequestClient;
import com.digibyte.midfinwealth.finqube.ecan.payload.CanIndFillEezzReq;

@RestController
@RequestMapping("/api/can")
public class ECanController {
	
	@Autowired
    private ECanRequestClient eCanRequestClient;

	@PostMapping(value = "/submit", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> submitRequest(@RequestBody CanIndFillEezzReq canIndFillEezzReq) {
        try {
            String response = eCanRequestClient.sendCanIndFillEezzRequest(canIndFillEezzReq);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }
}
