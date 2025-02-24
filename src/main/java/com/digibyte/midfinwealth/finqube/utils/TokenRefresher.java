package com.digibyte.midfinwealth.finqube.utils;

import com.digibyte.midfinwealth.finqube.exception.MFUApiException;
import com.digibyte.midfinwealth.finqube.oauth.service.MFUtilityAuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Naveen
 *
 * History:
 * -21-02-2025 <NaveenDhanasekaran> TokenRefresher
 *      - InitialVersion
 */

@Component
@RequiredArgsConstructor
public class TokenRefresher {
    private final MFUtilityAuthenticationService utilityAuthenticationService;


    @Scheduled(fixedRate = 23 * 60 * 60 * 1000)
    public void refreshToken() throws MFUApiException {
        utilityAuthenticationService.getAccessToken();
    }
}
