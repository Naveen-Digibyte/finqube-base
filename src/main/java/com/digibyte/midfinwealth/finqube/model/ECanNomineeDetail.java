package com.digibyte.midfinwealth.finqube.model;

import com.digibyte.midfinwealth.finqube.ecan.enums.NomineeRelation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author Naveen
 *
 * History:
 * -13-01-2025 <NaveenDhanasekaran> ECanNomineeDetail
 *      - InitialVersion
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ECanNomineeDetail {
    private String name;
    private NomineeRelation nomineeRelation;
    private byte percentage;
    private LocalDate dateOfBirth;
}
