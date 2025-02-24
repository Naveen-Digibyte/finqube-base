package com.digibyte.midfinwealth.finqube.transaction.payload;

import lombok.Data;

import java.util.List;

/**
 * @author Naveen
 *
 * History:
 * -21-02-2025 <NaveenDhanasekaran> NormalTransactionRequest
 *      - InitialVersion
 */

@Data
public class NormalTransactionRequest {
    String txnType;
    String entGroupRefNo;
    String orderMode;
    String folioTxnFlag;
    FolioDetSec folioDetSec;
    String can;
    String canType;
    String txnEvent;
    String reqPrntEnt;
    String riaCode;
    String arnCode;
    String subArnCode;
    String euin;
    String euinDeclaration;
    String subBrokCode;
    String branchRMIntCode;
    String totAmt;
    List<Schedule> schList;
    String dpSecFlag;
    DpSec dpSec;
    String paySecFlag;
    PaySec paySec;
    LogDtl logDtl;

    @Data
    public static class FolioDetSec {
        String holdNat;
        String taxStatus;
        String priPanOrPekrn;
        String secPanOrPekrn;
        String thrPanOrPekrn;
        String gurPanOrPekrn;
    }

    @Data
    public static class Schedule {
        String entUnqItrn;
        String mfuUtrn;
        String rtaAmcCode;
        String rtaSchCode;
        String outRtaSchCode;
        String folio;
        String divOpt;
        String txnVolTyp;
        String vol;
        String payOutFlag;
        PayOutDtl payOutDtl;
        String schPayFlag;
        SchPaySec schPaySec;
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
    public static class SchPaySec {
        String payType;
        String payRefNo;
        String payDate;
        String srcBnkId;
        String srcMicrNo;
        String srcIfscNo;
        String srcInvAccType;
        String srcInvAccNo;
        String targetBnkId;
        String targetMicrNo;
        String targetIfscNo;
        String targetInvAccType;
        String targetInvAccNo;
    }

    @Data
    public static class DpSec {
        String dpType;
        String dpAccNo;
    }

    @Data
    public static class PaySec {
        String directTranToAmcFlag;
        String payMode;
        String micr;
        String ifsc;
        String accType;
        String accNo;
        String payDate;
        String payAmt;
        String beneVan;
        String paymentBankRefNo;
        String mandateRefNo;
        String paymentConfirmTs;
        String amcPaymentTs;
    }

    @Data
    public static class LogDtl {
        String deviceType;
        String custIpAddress;
    }
}
