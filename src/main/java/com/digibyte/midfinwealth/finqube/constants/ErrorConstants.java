package com.digibyte.midfinwealth.finqube.constants;

/**
 * @author Sid
 * 
 * History:
 * -08-01-2025 <Sid> ErrorConstants
 * 		- InitialVersion
 * -12-01-2025 <NaveenDhanasekaran>
 *     	- Added errors form 12 to 40
 * -21-02-2025 <NaveenDhanasekaran>
 *      - Added error 41
 */

public class ErrorConstants {

    public static final String E_0001 = "E_0001: Invalid Username or Password";
    public static final String E_0002 = "E_0002: User not found with email: %s";
    public static final String E_0003 = "E_0003: Invalid Email";

    public static final String E_0004 = "E_0004: Email is already taken.";
    public static final String E_0005 = "E_0005: Username is already taken.";
    public static final String E_0006 = "E_0006: Mobile number is already registered.";
    public static final String E_0007 = "E_0007: Something went worng.";
    public static final String E_0008 = "E_0008: Error occurred while sending CAN Ind Fill Eezz request.";
    public static final String E_0009 = "E_0009: Error converting object to XML.";
    public static final String E_0010 = "E_0010: Error converting XML to JSON.";
    public static final String E_0011 = "E_0011: Error processing response from external service.";

    // ECan Request Validation error messages
    public static final String E_0012 = "E_0012: Name is mandatory and cannot be blank.";
    public static final String E_0013 = "E_0013: Date of Birth is mandatory and cannot be null.";
    public static final String E_0014 = "E_0014: PAN is mandatory and cannot be blank.";
    public static final String E_0015 = "E_0015: Mobile Number is mandatory and cannot be blank.";
    public static final String E_0016 = "E_0016: Email is mandatory and cannot be blank.";
    public static final String E_0017 = "E_0017: Mobile Number Declaration is mandatory.";
    public static final String E_0018 = "E_0018: Email Declaration is mandatory.";
    public static final String E_0019 = "E_0019: Holding Type is mandatory.";
    public static final String E_0020 = "E_0020: Investor Category is mandatory.";
    public static final String E_0021 = "E_0021: Tax Status is mandatory.";
    public static final String E_0022 = "E_0022: Holders should be at least 1.";
    public static final String E_0023 = "E_0023: Net Worth should be a positive value.";
    public static final String E_0024 = "E_0024: Source of Wealth is mandatory.";
    public static final String E_0025 = "E_0025: Occupation is mandatory.";
    public static final String E_0026 = "E_0026: PEP Status is mandatory.";
    public static final String E_0027 = "E_0027: Tax Residency inside India is mandatory.";
    public static final String E_0028 = "E_0028: Place of Birth is mandatory and cannot be blank.";
    public static final String E_0029 = "E_0029: Country of Birth is mandatory.";
    public static final String E_0030 = "E_0030: Country of Citizenship is mandatory.";
    public static final String E_0031 = "E_0031: Country of Nationality is mandatory.";
    public static final String E_0032 = "E_0032: Bank Details cannot be empty.";
    public static final String E_0033 = "E_0033: Nominee Flag is mandatory.";
    public static final String E_0034 = "E_0034: Nominee Verification Type is mandatory.";
    public static final String E_0035 = "E_0035: Nominee Details cannot be empty.";
    public static final String E_0036 = "E_0038: Failed to fetch bank details.";
    public static final String E_0037 = "E_0037: Bank detail not found for id: {}.";
    public static final String E_0038 = "E_0038: Failed to save bank details.";
    public static final String E_0039 = "E_0039: Failed to delete bank details.";
    public static final String E_0040 = "E_0040: Resource not found for id: {}.";
    public static final String E_0041 = "E_0041: Transaction was not successful.";
}
