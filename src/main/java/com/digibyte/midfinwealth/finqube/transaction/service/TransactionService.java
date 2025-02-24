package com.digibyte.midfinwealth.finqube.transaction.service;

import com.digibyte.midfinwealth.finqube.constants.ErrorConstants;
import com.digibyte.midfinwealth.finqube.constants.URLConstants;
import com.digibyte.midfinwealth.finqube.enums.ApiType;
import com.digibyte.midfinwealth.finqube.exception.MFUApiException;
import com.digibyte.midfinwealth.finqube.exception.TransactionException;
import com.digibyte.midfinwealth.finqube.transaction.enums.OrderStatus;
import com.digibyte.midfinwealth.finqube.transaction.payload.*;
import com.digibyte.midfinwealth.finqube.utils.MfUtilityHttpEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author Naveen
 *
 * History:
 * -21-02-2025 <NaveenDhanasekaran> TransactionService
 *      - InitialVersion
 * -21-02-2025 <NaveenDhanasekaran>
 *      - Altered getStringToResponseObject method to handle Failure response
 */

@Service
@RequiredArgsConstructor
public class TransactionService {
    
    private final MfUtilityHttpEntity utilityHttpEntity;
    
    public FetchUtrnResponse getUtrn(FetchUtrnRequest fetchUtrnRequest){
        try{
            return utilityHttpEntity.sendRequest(fetchUtrnRequest, ApiType.FETCH_UTRN, URLConstants.FETCH_UTRN, FetchUtrnResponse.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public NormalTransactionResponse.RespBody placeTransaction(NormalTransactionRequest normalTransactionRequest){
        try{
            return getStringToResponseObject(utilityHttpEntity.getResponse(normalTransactionRequest, ApiType.NORMAL_TXN, URLConstants.NORMAL_TAX));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public NormalTransactionResponse.RespBody placeSystematicTransactions(SystematicTransactionRequest systematicTransactionRequest){
        try{
            return getStringToResponseObject(utilityHttpEntity.getResponse(systematicTransactionRequest, ApiType.SYS_TXN, URLConstants.SYSTEMATIC_TRANSACTION));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public SystematicCancellationResponse.RespBody cancelSystematicTransaction(SystematicCancellationRequest cancellationRequest){
        try{
            return getStringToResponse(utilityHttpEntity.getResponse(cancellationRequest, ApiType.SYS_CANCEL_TXN, URLConstants.SYSTEMATIC_CANCEl));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    } 
    
    public TransactionAuthResponse getTransactionOrderAuth(TransactionAuthRequest transactionAuthRequest){
        try{
            return utilityHttpEntity.sendRequest(transactionAuthRequest, ApiType.TXN_AUT_DETH, URLConstants.TRANSACTION_ORDER_AUTH, TransactionAuthResponse.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public TransactionApprovalResponse getTransactionApproval(TransactionApprovalRequest transactionApprovalRequest){
        try{
            return utilityHttpEntity.sendRequest(transactionApprovalRequest, ApiType.TXN_APPROVAL, URLConstants.TRANSACTION_APPROVAL, TransactionApprovalResponse.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public TransactionHistoryResponse getTransactionHistory(TransactionHistoryRequest transactionHistoryRequest){
        try{
            return utilityHttpEntity.sendRequest(transactionHistoryRequest, ApiType.TXN_HIST, URLConstants.TRANSACTION_HISTORY, TransactionHistoryResponse.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private NormalTransactionResponse.RespBody getStringToResponseObject(String string) throws JsonProcessingException, MFUApiException {
        ObjectMapper objectMapper = new ObjectMapper();
        NormalTransactionResponse responseModel = objectMapper.readValue(string, NormalTransactionResponse.class);
        if (Objects.equals(responseModel.getRespHeader().getRespFlag(), "F")) {
            throw new MFUApiException(responseModel.getRespHeader().getErrorCode(), responseModel.getRespHeader().getErrorMsg());
        }
        if(responseModel.getRespBody().getOrdCreatedFlag().equals("N")){
            throw new TransactionException(responseModel.getRespBody().getSecWisErrorList(), ErrorConstants.E_0041);
        }
        for (NormalTransactionResponse.ItrnWiseStatus status : responseModel.getRespBody().getOrdDtl().getItrnList()) {
            if (isValidOrderStatus(status.getItrnOrdStatus())) {
                System.out.println("Valid status: " + status.getItrnOrdStatus());
            } else {
                System.out.println("Invalid status: " + status.getItrnOrdStatus());
            }
        }
        return responseModel.getRespBody();
    }

    private boolean isValidOrderStatus(String status) {
        try {
            OrderStatus.fromCode(status);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private SystematicCancellationResponse.RespBody getStringToResponse(String string) throws JsonProcessingException, MFUApiException {
        ObjectMapper objectMapper = new ObjectMapper();
        SystematicCancellationResponse responseModel = objectMapper.readValue(string, SystematicCancellationResponse.class);
        return responseModel.getRespBody();
    }
}
