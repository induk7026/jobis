package com.project.jobis.scrap.repository;

import com.project.jobis.scrap.doamin.Company;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    List<Company> findByUserId(Long userId);

}