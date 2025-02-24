package com.digibyte.midfinwealth.finqube.transaction.enums;

import lombok.Getter;

/**
 * @author Naveen
 *
 * History:
 * -21-02-2025 <NaveenDhanasekaran> OrderStatus
 *      - InitialVersion
 */

@Getter
public enum OrderStatus {
    RQ("Order Created"),
    CL("Order Canceled"),
    RA("RTA Accepted"),
    RR("RTA Rejected"),
    OR("Order Rejected"),
    OA("Order Accepted"),
    CK("Order Checked"),
    AC("Registration Accepted"),
    RJ("Registration Rejected"),
    RC("Registration Canceled"),
    CR("Registration Canceled by RTA"),
    SS("System Rejected"),
    CE("Order Ceased");

    private final String description;
    
    OrderStatus(String description) {
        this.description = description;
    }

    public static OrderStatus fromCode(String code) {
        for (OrderStatus status : OrderStatus.values()) {
            if (status.name().equals(code)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown order status code: " + code);
    }
}