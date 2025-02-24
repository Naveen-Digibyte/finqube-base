package com.digibyte.midfinwealth.finqube.transaction.payload;

import lombok.Data;

import java.util.List;

/**
 * @author Naveen
 *
 * History:
 * -21-02-2025 <NaveenDhanasekaran> FetchUtrnRequest
 *      - InitialVersion
 */

@Data
public class FetchUtrnRequest {

    private String reqType;
    private String can;
    private String entGroupRefNo;
    private List<SchListItem> schList;

    @Data
    public static class SchListItem {

        private String entUnqItrn;
        private String rtaAmcCode;

    }

}

