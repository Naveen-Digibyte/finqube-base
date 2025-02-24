package com.digibyte.midfinwealth.finqube.transaction.payload;

import lombok.Data;

import java.util.List;

/**
 * @author Naveen
 *
 * History:
 * -21-02-2025 <NaveenDhanasekaran> SystematicTransactionRequest
 *      - InitialVersion
 */

@Data
public class SystematicTransactionRequest {

    String txnType;
    String entGroupRefNo;
    String orderMode;
    String can;
    String canType;
    String reqPrntEnt;
    String riaCode;
    String arnCode;
    String subArnCode;
    String euin;
    String euinDeclaration;
    String subBrokCode;
    String branchRMIntCode;
    String totAmt;
    List<SysSch> sysSchList;
    String dpSecFlag;
    DpSec dpSec;
    String paySecFlag;
    PaySec paySec;
    String subSeqPayFlag;
    SubSeqSec subSeqSec;
    LogDtl logDtl;

    @Data
    public static class SysSch {
        String entUnqItrn;
        String rtaAmcCode;
        String rtaSchCode;
        String outRtaSchCode;
        String folio;
        String divOpt;
        String txnVolTyp;
        String vol;
        String frequency;
        String day;
        String startMonth;
        String startYear;
        String endMonth;
        String endYear;
        String payOutFlag;
        PayOutDtl payOutDtl;
        String priOtpFlag;
        String priMob;
        String priEmail;
    }

    @Data
    public static class PayOutDtl {
        String invAccNo;
        String micr;
        String ifsc;
    }

    @Data
    public static class DpSec {
        String dpType;
        String dpAccNo;
    }

    @Data
    public static class PaySec {
        String payMode;
        String micr;
        String ifsc;
        String accType;
        String accNo;
        String payDate;
        String payAmt;
        String beneVan;
        String paymentRefNo;
        String paymentBankRefNo;
        String mandateRefNo;
        String paymentConfirmTs;
        String amcPaymentTs;
    }

    @Data
    public static class SubSeqSec {
        String payMode;
        String invAccType;
        String invAccNo;
        String micr;
        String ifsc;
        String paymentRefNo;
    }

    @Data
    public static class LogDtl {
        String deviceType;
        String custIpAddress;
    }
}
