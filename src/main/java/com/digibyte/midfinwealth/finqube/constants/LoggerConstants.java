package com.digibyte.midfinwealth.finqube.constants;

/**
 * @author Sid
 * 
 * History:
 * -08-01-2025 <NaveenDhanaekaran> LoggerConstants
 *      - InitialVersion
 */

public class LoggerConstants {
    // Info messages
    public static final String FETCHING_ALL_BANK_DETAILS = "Fetching all bank details...";
    public static final String SUCCESSFULLY_FETCHED_BANK_DETAILS = "Successfully fetched {} bank details";
    public static final String FETCHING_BANK_DETAILS_BY_ID = "Fetching bank details for ID: {}";
    public static final String BANK_DETAILS_FOUND_FOR_ID = "Bank details found for ID: {}";
    public static final String SAVING_BANK_DETAILS = "Saving bank details with bank ID: {}";
    public static final String SUCCESSFULLY_SAVED_BANK_DETAILS = "Successfully saved bank details with ID: {}";
    public static final String ATTEMPTING_TO_DELETE_BANK_DETAILS = "Attempting to delete bank details with ID: {}";
    public static final String SUCCESSFULLY_DELETED_BANK_DETAILS = "Successfully deleted bank details with ID: {}";

    // Warn messages
    public static final String BANK_DETAILS_NOT_FOUND_FOR_ID = "Bank details not found for ID: {}";
    public static final String RESOURCE_NOT_FOUND = "Resource not found for ID: {}";

    // Error messages
    public static final String ERROR_FETCHING_BANK_DETAILS = "Error fetching bank details: {}";
    public static final String ERROR_SAVING_BANK_DETAILS = "Error saving bank details: {}";
    public static final String ERROR_DELETING_BANK_DETAILS = "Error deleting bank details: {}";

}
