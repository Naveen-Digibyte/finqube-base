package com.digibyte.midfinwealth.finqube.enums;

import lombok.Getter;

/**
 * @author Sid
 * 
 * History:
 * -19-02-2025 <Sid>
 *      - InitialVersion
 * -21-02-2025 <NaveenDhanasekaran>
 *     	- Changed PRN_VAL value
 */

@Getter
public enum ApiType {
	FETCH_UTRN("FETCH-UTRN"), NORMAL_TXN("NORMAL-TXN"), SYS_TXN("SYS-TXN"), SYS_CANCEL_TXN("SYS-CANCEL-TXN"),
	TXN_AUT_DETH("TXN-AUT-DETH"), TXN_APPROVAL("TXN-APPROVAL"), TXN_HIST("TXN-HIST"), CAN_VAL("CAN-VAL"),
	CAN_FETCH("CAN-FETCH"), PRN_VAL("PRN-VAL"), CAN_BNK_VAL("CAN-BNK-VAL"), SWP_PAYEEZ("SWP-PAYEEZ"),
	CAN_FOLIO_VAL("CAN-FOLIO-VAL"), INV_CON_ENTRY("INV-CON-ENTRY"), INV_CON_VIEW("INV-CON-VIEW");

	private final String code;

	ApiType(String code) {
		this.code = code;
	}
}
