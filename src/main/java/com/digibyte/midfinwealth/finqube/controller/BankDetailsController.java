package com.digibyte.midfinwealth.finqube.controller;

import com.digibyte.midfinwealth.finqube.constants.Constants;
import com.digibyte.midfinwealth.finqube.entity.BankDetails;
import com.digibyte.midfinwealth.finqube.model.ResponseModel;
import com.digibyte.midfinwealth.finqube.service.BankDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Sid
 *
 * History:
 * -12-02-2025 <NaveenDhanasekaran> BankDetailsController
 *      - InitialVersion
 */

@RestController
@RequestMapping("/api/bank-details")
public class BankDetailsController {

    @Autowired
    private BankDetailsService bankDetailsService;

    @GetMapping
    public ResponseEntity<ResponseModel> getAllBankDetails() {
        List<BankDetails> bankDetailsList = bankDetailsService.getAllBankDetails();
        return ResponseEntity.ok().body(new ResponseModel(Constants.POSITIVE, null, bankDetailsList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseModel> getBankDetailById(@PathVariable long id) {
        BankDetails bankDetail = bankDetailsService.getBankDetailById(id);
        return ResponseEntity.ok().body(new ResponseModel(Constants.POSITIVE, null, bankDetail));
    }

    @PostMapping
    public ResponseEntity<ResponseModel> saveBankDetail(@RequestBody BankDetails bankDetails) {
        BankDetails savedBankDetail = bankDetailsService.saveBankDetail(bankDetails);
        return ResponseEntity.status(201).body(new ResponseModel(Constants.POSITIVE, null, savedBankDetail));
    }
    
    @PostMapping("/bulk")
    public ResponseEntity<ResponseModel> saveAllBankDetail(@RequestBody List<BankDetails> bankDetails) {
        List<BankDetails> savedBankDetail = bankDetailsService.saveAllBankDetail(bankDetails);
        return ResponseEntity.status(201).body(new ResponseModel(Constants.POSITIVE, null, savedBankDetail));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseModel> deleteBankDetail(@PathVariable long id) {
        bankDetailsService.deleteBankDetail(id);
        return ResponseEntity.ok().body(new ResponseModel(Constants.POSITIVE, Constants.BANKDETAILDELETED, null));
    }
}