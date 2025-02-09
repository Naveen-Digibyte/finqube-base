package com.digibyte.midfinwealth.finqube.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digibyte.midfinwealth.finqube.domain.User;

/**
* @author Sid
*
* History:
* -08-01-2025 <Sid> UserRepo
*      - InitialVersion
*/

public interface UserRepo extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);

}
