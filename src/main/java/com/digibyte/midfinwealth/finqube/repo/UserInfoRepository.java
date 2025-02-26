package com.digibyte.midfinwealth.finqube.repo;

import com.digibyte.midfinwealth.finqube.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    Optional<UserInfo > findByCanId(String can);
}
