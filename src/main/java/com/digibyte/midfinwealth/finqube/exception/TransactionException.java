package com.digibyte.midfinwealth.finqube.exception;


import com.digibyte.midfinwealth.finqube.transaction.payload.NormalTransactionResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author Naveen
 *
 * History:
 * -21-02-2025 <NaveenDhanasekaran> TransactionException
 *      - InitialVersion
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class TransactionException extends RuntimeException{
    private List<NormalTransactionResponse.SecWisError> secWisError;
    private String message;
    public TransactionException(String message){
        super(message);
    }
    
    public TransactionException(List<NormalTransactionResponse.SecWisError> secWisErrorList, String messgae){
        this.message = messgae;
        this.secWisError = secWisErrorList;
    }
}
