package com.digibyte.midfinwealth.finqube.oauth.service;

import org.springframework.stereotype.Service;

import java.time.Instant;

/**
 * @author Naveen
 *
 * History:
 * -21-02-2025 <NaveenDhanasekaran> TokenService
 *      - InitialVersion
 */

@Service
public class TokenService {
    private String token;
    private Instant expiryTime;

    public synchronized void setToken(String token, long expiresInSeconds) {
        this.token = token;
        this.expiryTime = Instant.now().plusSeconds(expiresInSeconds);
    }

    public synchronized String getToken() {
        if (expiryTime == null || Instant.now().isAfter(expiryTime)) {
            return null; 
        }
        return token;
    }

    public synchronized boolean isTokenValid() {
        return expiryTime != null && Instant.now().isBefore(expiryTime);
    }
}
