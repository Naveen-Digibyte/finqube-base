package com.digibyte.midfinwealth.finqube.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Naveen
 *
 * History:
 * -13-01-2025 <NaveenDhanasekaran> BankDetails
 *      - InitialVersion
 */

@Entity
@Table(name = "fin_001_t_bankDetails")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class BankDetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fin_001_id")
    private long id;

    @Column(name = "fin_001_bankId")
    private String bankId;

    @Column(name = "fin_001_bankName")
    private String bankName;
}
