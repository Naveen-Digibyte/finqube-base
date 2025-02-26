package com.digibyte.midfinwealth.finqube.domain;

import com.digibyte.midfinwealth.finqube.ecan.enums.HoldingType;
import com.digibyte.midfinwealth.finqube.ecan.enums.InvestorCategory;
import com.digibyte.midfinwealth.finqube.ecan.enums.ResidentialStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "dfq_003_t_userInfo")
@Data
@Builder
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dfp_003_id")
    private long id;

    @Column(name = "dfp_003_can")
    private String canId;

    @Column(name = "dfp_003_investorCategory")
    private String investoryCategory;

    @Column(name = "dfp_003_canCategory")
    private String canCategory;

    @Column(name = "dfp_003_residentialStatus")
    private String residentialStatus;

    @Column(name = "dfp_003_pan")
    private String panPekrn;

    @Column(name = "dfp_003_firstApplicant")
    private String firstApplicant;

    @Column(name = "dfp_003_dateOfBirth")
    private LocalDate dateOfBirth;

    @Column(name = "dfp_003_placeOfIncorporation")
    private String placeofIncorporation;
    
    @Column(name = "dfp_003_commencementDate")
    private String commencementDate;
    
    @Column(name = "dfp_003_registrationNumber")
    private String registrationNumber;
    
    @Column(name = "dfp_003_jointOnePan")
    private String jointOnePan;
    
    @Column(name = "dfp_003_secondApplicant")
    private String secondApplicant;
    
    @Column(name = "dfp_003_jointOneDateOfBirth")
    private LocalDate jointOneDateOfBirth;
    
    @Column(name = "dfp_003_jointTwoPan")
    private String jointTwoPan;
    
    @Column(name = "dfp_003_jointTwoApplicant")
    private String jointTwoApplicant;
    
    @Column(name = "dfp_003_jointTwoDateOfBirth")
    private LocalDate jointTwoDateOfBirth;
    
    @Column(name = "dfp_003_RegDate")
    private LocalDate regnDate;
    
    @Column(name = "dfp_003_addressOne")
    private String addressOne;
    
    @Column(name = "dfp_003_addressTwo")
    private String addressTwo;
    
    @Column(name = "dfp_003_addressThree")
    private String addressThree;
    
    @Column(name = "dfp_003_city")
    private String city;
    
    @Column(name = "dfp_003_state")
    private String state;
    
    @Column(name = "dfp_003_pinCode")
    private int pinCode;
    
    @Column(name = "dfp_003_holdingType")
    private String holdingType;

    @OneToOne
    @JoinColumn(name = "dfp_003_user", referencedColumnName = "crm_001_user_id")
    private User user;
}
