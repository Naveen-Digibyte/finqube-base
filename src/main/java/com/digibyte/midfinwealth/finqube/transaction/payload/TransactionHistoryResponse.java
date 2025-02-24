package com.digibyte.midfinwealth.finqube.transaction.payload;

import lombok.Data;

import java.util.List;

/**
 * @author Naveen
 *
 * History:
 * -21-02-2025 <NaveenDhanasekaran> TransactionHistoryResponse
 *      - InitialVersion
 */

@Data
public class TransactionHistoryResponse {
    private String mfuGorn;
    private List<OrderHistory> orderHistList;

    @Data
    public static class OrderHistory {
        private String pan;
        private String orderNo;
        private String orderHistoryRefNo;
        private String event;
        private String eventTs;
        private String eventEntity;
        private String eventEntityName;
        private String eventUser;
        private String eventUserName;
        private String eventUserLevel;
        private String rtaRemarks;
        private String internalRemarks;
    }
}
