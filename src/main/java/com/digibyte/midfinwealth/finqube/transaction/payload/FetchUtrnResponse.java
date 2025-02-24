package com.digibyte.midfinwealth.finqube.transaction.payload;

import lombok.Data;

import java.util.List;

/**
 * @author Naveen
 *
 * History:
 * -21-02-2025 <NaveenDhanasekaran> FetchUtrnResponse
 *      - InitialVersion
 */

@Data
public class FetchUtrnResponse {
    
    private List<UtrnListItem> utrnLst;

    public static class UtrnListItem {

        private String entUnqItrn;
        private String mfuUtrn;

    }

}


