package com.digibyte.midfinwealth.finqube.ecan.payload;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
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
public class HolderRecords {
	
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "HOLDER_RECORD")
    private List<HolderRecord> holderRecord;
    
}
