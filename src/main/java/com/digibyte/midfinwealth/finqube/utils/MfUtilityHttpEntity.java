package com.digibyte.midfinwealth.finqube.utils;

import com.digibyte.midfinwealth.finqube.constants.Constants;
import com.digibyte.midfinwealth.finqube.enums.ApiType;
import com.digibyte.midfinwealth.finqube.exception.ECanException;
import com.digibyte.midfinwealth.finqube.exception.MFUApiException;
import com.digibyte.midfinwealth.finqube.model.CanResponseModel;
import com.digibyte.midfinwealth.finqube.model.mfUtility.MFUtilityRequest;
import com.digibyte.midfinwealth.finqube.oauth.service.MFUtilityAuthenticationService;
import com.digibyte.midfinwealth.finqube.oauth.service.TokenService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Objects;

/**
 * @author Naveen
 * 
 * History:
 * -21-02-2025 <NaveenDhanasekaran> BankResponseModel
 *      - InitialVersion
 *      - Created getStringToResponseObject and sendRequest.
 */

@Service
@RequiredArgsConstructor
public class MfUtilityHttpEntity {

    private final ObjectMapper objectMapper;
    private final RestTemplate restTemplate;
    private final EncryptionService encryptionService;
    private final MFUtilityAuthenticationService utilityAuthenticationService;

    @Value("${mfu.base-url}")
    private String baseUrl;

    @Value("${mfu.entity-id}")
    private String entityId;

    @Value("${mfu.client-id}")
    private String clientId;

    @Value("${mfu.client-secret}")
    private String clientSecret;

    @Value("${finqube.version}")
    private String version;

    @Value("${finqube.password}")
    private String password;

    public MFUtilityRequest.ReqHeader createRequestHeader(ApiType apiType) throws InvalidAlgorithmParameterException, NoSuchPaddingException, UnsupportedEncodingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, NoSuchProviderException, InvalidKeyException {
        return MFUtilityRequest.ReqHeader.builder()
                .entityId(entityId)
                .version(version)
                .reqTS(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .apiType(apiType.getCode())
                .userId(encryptionService.encrypt(clientId))
                .encryptPwd(encryptionService.encrypt(password))
                .uniqueId(generateUniqueId())
                .build();
    }

    public <T> MFUtilityRequest encryptRequest(T validCanRequestModel, ApiType apiType) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(validCanRequestModel);

            return MFUtilityRequest.builder()
                    .reqHeader(createRequestHeader(apiType))
                    .reqBody(MFUtilityRequest.ReqBody.builder()
                            .data(encryptionService.encrypt(jsonString))
                            .build())
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private String generateUniqueId() {
        return String.format("%010d", System.currentTimeMillis() % 10000000000L);
    }

    public <T> HttpEntity<String> getHeader(T requestBody, ApiType apiType) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        System.out.println("access token : " + utilityAuthenticationService.getToken());
        headers.set("Authorization", Constants.BEARER + utilityAuthenticationService.getToken());
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        String payload = objectMapper.writeValueAsString(encryptRequest(requestBody, apiType));
        return new HttpEntity<>(payload, headers);
    }

    public <T> String getResponse(T requestBody, ApiType apiType, String urlConstants) {
        try {
            ResponseEntity<?> repsEntity = restTemplate.exchange(
                    baseUrl + urlConstants, HttpMethod.POST,
                    getHeader(requestBody, apiType),
                    String.class
            );
            return encryptionService.decrypt(getSuccessResponse(Objects.requireNonNull(repsEntity.getBody()).toString()));
        } catch (JsonProcessingException exception) {
            throw new ECanException(exception.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String getSuccessResponse(String responseBody) {
        JSONObject json = new JSONObject(responseBody);
        return json.getString("respData");
    }

    public <T> T getStringToResponseObject(String string, Class<T> type) throws JsonProcessingException, MFUApiException {
        ObjectMapper objectMapper = new ObjectMapper();
        CanResponseModel<?> responseModel = objectMapper.readValue(string, new TypeReference<>() {
        });
        if (Objects.equals(responseModel.getRespHeader().getRespFlag(), "F")) {
            throw new MFUApiException(responseModel.getRespHeader().getErrorCode(), responseModel.getRespHeader().getErrorMsg());
        }
        return objectMapper.convertValue(responseModel.getRespBody(), type);
    }

    public <T, R> R sendRequest(T requestBody, ApiType apiType, String urlConstants, Class<R> responseType) {
        try {
            return getStringToResponseObject(getResponse(requestBody, apiType, urlConstants), responseType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error processing JSON response", e);
        } catch (Exception e) {
            throw new RuntimeException("Failed to get API response", e);
        }
    }
}
