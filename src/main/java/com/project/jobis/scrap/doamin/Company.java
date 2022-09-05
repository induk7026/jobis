package com.project.jobis.scrap.doamin;

import com.project.jobis.scrap.enums.IncomeType;
import com.project.jobis.user.domain.User;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String incomeDetails;
    private String companyName;
    private String name;
    private String regNo;
    private IncomeType incomeType;
    private String businessNumber;
    private BigDecimal totalPayment;
    private LocalDateTime workStartDate;
    private LocalDateTime workEndDate;
    private LocalDateTime paymentDate;

}
