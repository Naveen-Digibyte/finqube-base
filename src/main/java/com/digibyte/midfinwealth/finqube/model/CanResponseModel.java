package com.digibyte.midfinwealth.finqube.model;

import com.digibyte.midfinwealth.finqube.model.mfUtility.MFResponseHeader;
import lombok.Data;

/**
 * @author Naveen
 *
 * History:
 * -21-02-2025 <NaveenDhanasekaran> CanResponseModel
 *      - InitialVersion
 */

@Data
public class CanResponseModel<T> {

    private MFResponseHeader respHeader;
    private T respBody;
    
}
