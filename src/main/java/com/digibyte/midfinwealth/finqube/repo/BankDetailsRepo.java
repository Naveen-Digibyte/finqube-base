package com.digibyte.midfinwealth.finqube.repo;

import com.digibyte.midfinwealth.finqube.entity.BankDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Naveen
 *
 * History:
 * -12-01-2025 <NaveenDhanasekaran> BankDetailsRepo
 *      - InitialVersion
 */

@Repository
public interface BankDetailsRepo extends JpaRepository<BankDetails, Long> {
    Optional<BankDetails> findByBankName(String name);
}
