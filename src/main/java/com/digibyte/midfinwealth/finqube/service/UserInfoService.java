package com.digibyte.midfinwealth.finqube.service;

import com.digibyte.midfinwealth.finqube.domain.User;
import com.digibyte.midfinwealth.finqube.domain.UserInfo;
import com.digibyte.midfinwealth.finqube.model.sample.UserEmailMobile;
import com.digibyte.midfinwealth.finqube.repo.UserInfoRepository;
import com.digibyte.midfinwealth.finqube.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserInfoService {
    
    private final UserInfoRepository userInfoRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepo userRepository;

    public UserInfo saveUserInfo(UserInfo userInfo){
        return userInfoRepository.save(UserInfo.builder()
                        .canId(userInfo.getCanId())
                        .investoryCategory(userInfo.getInvestoryCategory())
                        .residentialStatus(userInfo.getResidentialStatus())
                        .panPekrn(userInfo.getPanPekrn())
                        .dateOfBirth(userInfo.getDateOfBirth())
                        .placeofIncorporation(userInfo.getPlaceofIncorporation())
                        .commencementDate(userInfo.getCommencementDate())
                        .registrationNumber(userInfo.getRegistrationNumber())
                        .jointOnePan(userInfo.getJointOnePan())
                        .secondApplicant(userInfo.getSecondApplicant())
                        .jointOneDateOfBirth(userInfo.getJointOneDateOfBirth())
                        .jointTwoPan(userInfo.getJointTwoPan())
                        .jointTwoApplicant(userInfo.getJointTwoApplicant())
                        .jointTwoDateOfBirth(userInfo.getJointTwoDateOfBirth())
                        .regnDate(LocalDate.now())
                        .addressOne(userInfo.getAddressOne())
                        .addressTwo(userInfo.getAddressTwo())
                        .addressThree(userInfo.getAddressThree())
                        .city(userInfo.getCity())
                        .state(userInfo.getState())
                        .pinCode(userInfo.getPinCode())
                        .holdingType(userInfo.getHoldingType())
                .build());
    }
    
    public List<UserInfo> loadManyData(List<UserInfo> userInfos){
        return userInfoRepository.saveAll(userInfos);
    }
    
    public List<UserInfo> getAllUser(){
        return userInfoRepository.findAll();
    }
    
    public UserInfo getById(long id){
        Optional<UserInfo> userExist = userInfoRepository.findById(id);
        return userExist.orElse(null);
    }

    public void updateContactDetails(List<UserEmailMobile> userEmailMobiles ){
        for(UserEmailMobile userEmailMobile: userEmailMobiles){
            Optional<UserInfo> userInfoExist = userInfoRepository.findByCanId(userEmailMobile.getCanId());
            if(userInfoExist.isPresent()){
                UserInfo userInfo = userInfoExist.get();
                User user = userRepository.save(User.builder()
                        .userName(userInfo.getFirstApplicant())
                        .email(userEmailMobile.getPrimaryEmail())
                        .mobileNumber(userEmailMobile.getPrimaryMobile())
                        .password(passwordEncoder.encode("Test@123"))
                        .build());
                userInfo.setUser(user);
                userInfoRepository.save(userInfo);
            }
        }
    }

}
