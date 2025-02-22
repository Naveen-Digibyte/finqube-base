package com.digibyte.midfinwealth.finqube.ecan.payload;

import com.digibyte.midfinwealth.finqube.ecan.enums.PrimaryHolderDeclaration;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sid
 * 
 * History:
 * -08-01-2025 <Sid> UserRepo
 *      - InitialVersion
 * -12-02-2025 <NaveenDhanasekaran>
 *      - changed type for priMobBelongsTo and priEmailBelongsTo
 */

/**
* @author Sid
*
* History:
* -19=02-2025 <Sid> 
*      - InitialVersion
*/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDetail {
	
    @JacksonXmlProperty(localName = "PRI_MOB_NO")
    private String priMobNo;

    @JacksonXmlProperty(localName = "PRI_MOB_BELONGSTO")
    private PrimaryHolderDeclaration priMobBelongsTo;

    @JacksonXmlProperty(localName = "PRI_EMAIL")
    private String priEmail;

    @JacksonXmlProperty(localName = "PRI_EMAIL_BELONGSTO")
    private PrimaryHolderDeclaration priEmailBelongsTo;
}