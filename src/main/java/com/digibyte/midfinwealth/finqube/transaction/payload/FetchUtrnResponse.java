package com.digibyte.midfinwealth.finqube.transaction.payload;

import lombok.Data;

import java.util.List;

/**
 * @author Naveen
 *
 * History:
 * -21-02-2025 <NaveenDhanasekaran> FetchUtrnResponse
 *      - InitialVersion
 * -24-02-2025 <NaveenDhanasekaran>
 *     	- Added @Data annotation for UtrnListItem
 */

@Data
public class FetchUtrnResponse {
    
    private List<UtrnListItem> utrnLst;

    @Data
    public static class UtrnListItem {

        private String entUnqItrn;
        private String mfuUtrn;

    }

}


