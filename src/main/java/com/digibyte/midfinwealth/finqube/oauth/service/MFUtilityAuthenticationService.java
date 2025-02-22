package com.digibyte.midfinwealth.finqube.oauth.service;

import com.digibyte.midfinwealth.finqube.constants.Constants;
import com.digibyte.midfinwealth.finqube.constants.URLConstants;
import com.digibyte.midfinwealth.finqube.exception.MFUApiException;
import com.digibyte.midfinwealth.finqube.model.TokenResponse;
import com.digibyte.midfinwealth.finqube.utils.EncryptionService;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Naveen
 *
 * History:
 * -20-02-2025 <NaveenDhanasekaran> MFUtilityAuthenticationService
 *      - InitialVersion
 */

@Service
@RequiredArgsConstructor
public class MFUtilityAuthenticationService {

    private final RestTemplate restTemplate;
    private final EncryptionService encryptionService;

    @Value("${mfu.base-url}")
    private String baseUrl;
    
    @Value("${mfu.entity-id}")
    private String entityId;

    @Value("${mfu.client-id}")
    private String clientId;

    @Value("${mfu.client-secret}")
    private String clientSecret;
    
    public String getAccessToken() throws Exception {

        String encryptedUsername = encryptionService.encrypt(clientId);
        String encryptedPassword = encryptionService.encrypt(clientSecret);

        HttpEntity<String> entity = getStringHttpEntity(encryptedUsername, encryptedPassword);
        ResponseEntity<String> response = restTemplate.exchange(
                baseUrl + URLConstants.GET_ACCESS_TOKEN,
                HttpMethod.POST,
                entity,
                String.class
        );
        if (response.getStatusCode().is2xxSuccessful()) {
            TokenResponse resp = parseSuccessResponse(response.getBody());
            return resp.getAccessToken();
        } else {
            throw parseErrorResponse(response.getBody());
        }
    }

    private HttpEntity<String> getStringHttpEntity(String encryptedUsername, String encryptedPassword) {
        JSONObject requestBody = new JSONObject();
        JSONObject reqBody = new JSONObject();
        reqBody.put(Constants.ENTITY_ID, entityId);
        reqBody.put(Constants.CLIENT_USER, encryptedUsername);
        reqBody.put(Constants.CLIENT_PWD, encryptedPassword);
        requestBody.put(Constants.REQ_BODY, reqBody);
        HttpHeaders headers = new HttpHeaders();
        headers.set(Constants.CONTENT_TYPE, String.valueOf(MediaType.APPLICATION_JSON));
        return new HttpEntity<>(requestBody.toString(), headers);
    }

    private TokenResponse parseSuccessResponse(String responseBody) {
        JSONObject json = new JSONObject(responseBody);
        return new TokenResponse(
                json.getString(Constants.ACCESS_TOKEN),
                json.getString(Constants.TOKEN_TYPE),
                json.getInt(Constants.EXPIRES_IN)
        );
    }

    private MFUApiException parseErrorResponse(String responseBody) {
        JSONObject json = new JSONObject(responseBody);
        return new MFUApiException(
                json.getString(Constants.ERROR_CODE),
                json.getString(Constants.ERROR_MSG)
        );
    }
}
