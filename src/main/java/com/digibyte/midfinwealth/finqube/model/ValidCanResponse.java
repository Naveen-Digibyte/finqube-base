package com.digibyte.midfinwealth.finqube.model;

import com.digibyte.midfinwealth.finqube.utils.BooleanDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

/**
 * @author Naveen
 *
 * History:
 * -21-02-2025 <NaveenDhanasekaran> ValidCanResponse
 *      - InitialVersion
 */

@Data
public class ValidCanResponse {

    @JsonDeserialize(using = BooleanDeserializer.class)
    private Boolean isValidCan;

    @JsonDeserialize(using = BooleanDeserializer.class)
    private Boolean isValidPan;

    @JsonDeserialize(using = BooleanDeserializer.class)
    private Boolean isValidDob;

    @JsonDeserialize(using = BooleanDeserializer.class)
    private Boolean isValidEmail;

    private String canStatus;

    @JsonDeserialize(using = BooleanDeserializer.class)
    private Boolean allowForTrans;

    private String accountCategory;
    private String canModeOfHolding;
}
