package com.digibyte.midfinwealth.finqube.model;

import com.digibyte.midfinwealth.finqube.constants.ErrorConstants;
import com.digibyte.midfinwealth.finqube.ecan.enums.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Naveen
 *
 * History:
 * -13-01-2025 <NaveenDhanasekaran> ECanRequestModel
 *      - InitialVersion
 * -19-02-2025 <NaveenDhanasekaran>
 *      - Changed field name eCanNomineeDetails to nomineeDetails
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ECanRequestModel {

    @NotBlank(message = ErrorConstants.E_0012)
    private String name;

    @NotNull(message = ErrorConstants.E_0013)
    private LocalDate dateOfBirth;

    @NotBlank(message = ErrorConstants.E_0014)
    private String pan;

    @NotBlank(message = ErrorConstants.E_0015)
    private String mobileNumber;

    @NotBlank(message = ErrorConstants.E_0016)
    private String email;

    @NotNull(message = ErrorConstants.E_0017)
    private PrimaryHolderDeclaration mobileNumberDeclaration;

    @NotNull(message = ErrorConstants.E_0018)
    private PrimaryHolderDeclaration emailDeclaration;

    @NotNull(message = ErrorConstants.E_0019)
    private HoldingType holdingType;

    @NotNull(message = ErrorConstants.E_0020)
    private InvestorCategory investorCategory;

    @NotNull(message = ErrorConstants.E_0021)
    private ResidentialStatus taxStatus;

    @Min(value = 1, message = ErrorConstants.E_0022)
    private int holders;

    private GrossIncome grossIncome;

    @Min(value = 0, message = ErrorConstants.E_0023)
    private long netWorth;

    private LocalDate netWorthDate;

    @NotNull(message = ErrorConstants.E_0024)
    private SourceOfWealth sourceOfWealth;

    @NotNull(message = ErrorConstants.E_0025)
    private Occupation occupation;

    @NotNull(message = ErrorConstants.E_0026)
    private PepStatus pepStatus;

    @NotNull(message = ErrorConstants.E_0027)
    private ConfirmationStatus taxResidencyInsideIndia;

    @NotBlank(message = ErrorConstants.E_0028)
    private String placeOfBirth;

    @NotNull(message = ErrorConstants.E_0029)
    private Country countryOfBirth;

    @NotNull(message = ErrorConstants.E_0030)
    private Country countryOfCitizenship;

    @NotNull(message = ErrorConstants.E_0031)
    private Country countryOfNationality;

    @NotEmpty(message = ErrorConstants.E_0032)
    @Valid
    private List<ECanBankDetails> bankDetails;

    @NotNull(message = ErrorConstants.E_0033)
    private NomineeOptionFlag nomineeFlag;

    @NotNull(message = ErrorConstants.E_0034)
    private NomineeVerificationType verificationType;

    @NotEmpty(message = ErrorConstants.E_0035)
    @Valid
    private List<ECanNomineeDetail> nomineeDetails;
}
