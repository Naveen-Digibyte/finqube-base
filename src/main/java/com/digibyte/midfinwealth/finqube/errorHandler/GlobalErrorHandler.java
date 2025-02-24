package com.digibyte.midfinwealth.finqube.errorHandler;

import com.digibyte.midfinwealth.finqube.constants.Constants;
import com.digibyte.midfinwealth.finqube.exception.AuthenticationException;
import com.digibyte.midfinwealth.finqube.exception.ECanException;
import com.digibyte.midfinwealth.finqube.exception.TransactionException;
import com.digibyte.midfinwealth.finqube.model.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Naveen
 *
 * History:
 * -13-01-2025 <NaveenDhanasekaran> GlobalErrorHandler
 *      - InitialVersion
 * -21-02-2025 <NaveenDhanasekaran>
 *      - Added methods to handle TransactionException
 */

@RestControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseModel> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseModel(Constants.NEGATIVE, null, errors));
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<Object> handleMailingAddressException(final AuthenticationException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(createResponse(e));
    }

    @ExceptionHandler(ECanException.class)
    public ResponseEntity<Object> handleECanException(final ECanException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(createResponse(e));
    }

    @ExceptionHandler(TransactionException.class)
    public ResponseEntity<Object> handleTransactionException(final TransactionException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(createTransactionResponse(e));
    }

    private ResponseModel createResponse(Exception e) {
        return new ResponseModel(Constants.NEGATIVE, e.getMessage(), null);
    }

    private ResponseModel createTransactionResponse(TransactionException e) {
        return new ResponseModel(Constants.NEGATIVE, e.getMessage(), e.getSecWisError());
    }

}
