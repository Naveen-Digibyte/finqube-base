package com.digibyte.midfinwealth.finqube.service;

import com.digibyte.midfinwealth.finqube.constants.ErrorConstants;
import com.digibyte.midfinwealth.finqube.constants.LoggerConstants;
import com.digibyte.midfinwealth.finqube.entity.BankDetails;
import com.digibyte.midfinwealth.finqube.exceptions.ResourceNotFoundException;
import com.digibyte.midfinwealth.finqube.repo.BankDetailsRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author Naveen
 *
 * History:
 * -13-01-2025 <NaveenDhanasekaran> BankDetailsService
 *      - InitialVersion
 */

@Service
public class BankDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(BankDetailsService.class);

    @Autowired
    private BankDetailsRepo bankDetailsRepo;

    public List<BankDetails> getAllBankDetails() {
        try {
            logger.info(LoggerConstants.FETCHING_ALL_BANK_DETAILS);
            List<BankDetails> bankDetailsList = bankDetailsRepo.findAll();
            logger.info(LoggerConstants.SUCCESSFULLY_FETCHED_BANK_DETAILS, bankDetailsList.size());
            return bankDetailsList;
        } catch (Exception e) {
            logger.error(LoggerConstants.ERROR_FETCHING_BANK_DETAILS, e.getMessage(), e);
            throw new RuntimeException(ErrorConstants.E_0036, e);
        }
    }

    public BankDetails getBankDetailById(long id) {
        try {
            logger.info(LoggerConstants.FETCHING_BANK_DETAILS_BY_ID, id);
            Optional<BankDetails> bankDetail = bankDetailsRepo.findById(id);
            if (bankDetail.isPresent()) {
                logger.info(LoggerConstants.BANK_DETAILS_FOUND_FOR_ID, id);
                return bankDetail.get();
            } else {
                logger.warn(LoggerConstants.BANK_DETAILS_NOT_FOUND_FOR_ID, id);
                throw new ResourceNotFoundException(String.format(ErrorConstants.E_0037, id));
            }
        } catch (Exception e) {
            logger.error(LoggerConstants.ERROR_FETCHING_BANK_DETAILS, id, e.getMessage(), e);
            throw new RuntimeException(ErrorConstants.E_0036, e);
        }
    }

    @Transactional
    public BankDetails saveBankDetail(BankDetails bankDetails) {
        try {
            logger.info(LoggerConstants.SAVING_BANK_DETAILS, bankDetails.getBankId());
            BankDetails savedBankDetail = bankDetailsRepo.save(bankDetails);
            logger.info(LoggerConstants.SUCCESSFULLY_SAVED_BANK_DETAILS, savedBankDetail.getId());
            return savedBankDetail;
        } catch (Exception e) {
            logger.error(LoggerConstants.ERROR_SAVING_BANK_DETAILS, e.getMessage(), e);
            throw new RuntimeException(ErrorConstants.E_0038, e);
        }
    }

    @Transactional
    public List<BankDetails> saveAllBankDetail(List<BankDetails> bankDetails) {
        try {
            List<BankDetails> savedBankDetail = bankDetailsRepo.saveAll(bankDetails);
            return savedBankDetail;
        } catch (Exception e) {
            logger.error(LoggerConstants.ERROR_SAVING_BANK_DETAILS, e.getMessage(), e);
            throw new RuntimeException(ErrorConstants.E_0038, e);
        }
    }

    public void deleteBankDetail(long id) {
        try {
            logger.info(LoggerConstants.ATTEMPTING_TO_DELETE_BANK_DETAILS, id);
            if (bankDetailsRepo.existsById(id)) {
                bankDetailsRepo.deleteById(id);
                logger.info(LoggerConstants.SUCCESSFULLY_DELETED_BANK_DETAILS, id);
            } else {
                logger.warn(LoggerConstants.RESOURCE_NOT_FOUND, id);
                throw new ResourceNotFoundException(String.format(ErrorConstants.E_0040, id));
            }
        } catch (Exception e) {
            logger.error(LoggerConstants.ERROR_DELETING_BANK_DETAILS, id, e.getMessage(), e);
            throw new RuntimeException(ErrorConstants.E_0039, e);
        }
    }

}
