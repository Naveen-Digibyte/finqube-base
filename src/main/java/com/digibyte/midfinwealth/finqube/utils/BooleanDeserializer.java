package com.digibyte.midfinwealth.finqube.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

/**
 * @author Naveen
 *
 * History:
 * -21-02-2025 <NaveenDhanasekaran> BooleanDeserializer
 *      - InitialVersion
 */

public class BooleanDeserializer extends JsonDeserializer<Boolean> {
    @Override
    public Boolean deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = p.getText().toUpperCase();
        return value.equals("TRUE");
    }
}