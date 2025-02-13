package com.digibyte.midfinwealth.finqube.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digibyte.midfinwealth.finqube.domain.User;

/**
 * @author Sid
 * <p>
 * History:
 * -08-01-2025 <Sid> UserRepo
 *      - InitialVersion
 * -12-02-2025 <NaveenDhanasekaran>
 *      - created existsByEmail,existsByUserName and existsByMobileNumber
 */

public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsByUserName(String userName);

    boolean existsByMobileNumber(String mobileNumber);

}
