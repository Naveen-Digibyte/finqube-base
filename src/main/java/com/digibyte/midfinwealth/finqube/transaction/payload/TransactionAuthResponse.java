package com.digibyte.midfinwealth.finqube.transaction.payload;

import lombok.Data;

import java.util.List;

/**
 * @author Naveen
 *
 * History:
 * -21-02-2025 <NaveenDhanasekaran> TransactionAuthResponse
 *      - InitialVersion
 */

@Data
public class TransactionAuthResponse {
    
    GornOrdDet gornOrdDet;
    AuthMasterDet authMasterDet;
    String verfierApprPan;
    List<String> apprLvlList;

    @Data
    public static class GornOrdDet {
        String can;
        String mfuGorn;
        String entGroupRefNo;
        String txnType;
        String noOfSch;
        String totalAmt;
        String ordStatus;
        String ordInsertTs;
        String ordBussTs;
        String payMode;
        String payInstrNo;
        List<ItrnList> itrnList;

        @Data
        public static class ItrnList {
            String itrn;
            String entUnqItrn;
            String itrnTxnType;
            String volType;
            String value;
            String payStatus;
            String itrnTxnSt;
            String schCode;
            String schName;
            String divOpt;
            String reqFolio;
            String reqFolioCkDigit;
            String utrn;
            String ftrnBkTs;
            String rspUnits;
            String rspAmt;
            String rspPrice;
            String rspValDate;
            String rspFolio;
            String rspFolioCkDigit;
        }
    }

    @Data
    public static class AuthMasterDet {
        List<LvlSetDet> grpLvlList;
        String l1Pans;
        String l2Pans;
        String l3Pans;
        String l4Pans;
        String l5Pans;
        String selPans;
        String verfPans;

        @Data
        public static class LvlSetDet {
            String lvlSetDet;
        }
    }
}