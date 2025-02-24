package com.digibyte.midfinwealth.finqube.controller;

import com.digibyte.midfinwealth.finqube.constants.Constants;
import com.digibyte.midfinwealth.finqube.exception.MFUApiException;
import com.digibyte.midfinwealth.finqube.model.ResponseModel;
import com.digibyte.midfinwealth.finqube.transaction.payload.*;
import com.digibyte.midfinwealth.finqube.transaction.service.BankValidationService;
import com.digibyte.midfinwealth.finqube.transaction.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Naveen
 *
 * History:
 * -21-02-2025 <NaveenDhanasekaran>
 *     	- InitialVersion
 *     	- Added all transaction apis
 */

@RestController
@RequestMapping("/api/trans")
@RequiredArgsConstructor
public class TranscrationController {
    
    private final BankValidationService bankValidationService;
    private final TransactionService  transactionService;
    
    @GetMapping("/check/bank")
    public ResponseEntity<ResponseModel> checkCanBank(@RequestBody CanBankValidRequest bankValidRequestBody) throws MFUApiException {
        return ResponseEntity.ok().body(new ResponseModel(Constants.POSITIVE,null, bankValidationService.checkCanBankValidation(bankValidRequestBody)));
    }

    @GetMapping("/check/utrn")
    public ResponseEntity<ResponseModel> fetchUtrn(@RequestBody FetchUtrnRequest fetchUtrnRequest) throws MFUApiException {
        return ResponseEntity.ok().body(new ResponseModel(Constants.POSITIVE,null, transactionService.getUtrn(fetchUtrnRequest)));
    }
    
    @PostMapping("/order")
    public ResponseEntity<ResponseModel> placeTransaction(@RequestBody NormalTransactionRequest normalTransactionRequest){
        return ResponseEntity.ok().body(new ResponseModel(Constants.POSITIVE, null, transactionService.placeTransaction(normalTransactionRequest)));
    }

    @PostMapping("/order/systematic")
    public ResponseEntity<ResponseModel> placeSystematicOrders(@RequestBody SystematicTransactionRequest systematicTransactionRequest){
        return ResponseEntity.ok().body(new ResponseModel(Constants.POSITIVE, null, transactionService.placeSystematicTransactions(systematicTransactionRequest)));
    }

    @PostMapping("/cancel/systematic")
    public ResponseEntity<ResponseModel> cancelSystematicOrders(@RequestBody SystematicCancellationRequest systematicCancellationRequest){
        return ResponseEntity.ok().body(new ResponseModel(Constants.POSITIVE, null, transactionService.cancelSystematicTransaction(systematicCancellationRequest)));
    }

    @GetMapping("/order/auth")
    public ResponseEntity<ResponseModel> getOrderAuthentication(@RequestBody TransactionAuthRequest transactionAuthRequest) throws MFUApiException {
        return ResponseEntity.ok().body(new ResponseModel(Constants.POSITIVE,null, transactionService.getTransactionOrderAuth(transactionAuthRequest)));
    }

    @GetMapping("/order/approval")
    public ResponseEntity<ResponseModel> getOrderApproval(@RequestBody TransactionApprovalRequest transactionApprovalRequest) throws MFUApiException {
        return ResponseEntity.ok().body(new ResponseModel(Constants.POSITIVE,null, transactionService.getTransactionApproval(transactionApprovalRequest)));
    }

    @GetMapping("/order/history")
    public ResponseEntity<ResponseModel> getOrderHistory(@RequestBody TransactionHistoryRequest transactionHistoryRequest) throws MFUApiException {
        return ResponseEntity.ok().body(new ResponseModel(Constants.POSITIVE,null, transactionService.getTransactionHistory(transactionHistoryRequest)));
    }
}
