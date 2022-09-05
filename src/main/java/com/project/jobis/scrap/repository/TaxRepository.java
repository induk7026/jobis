package com.project.jobis.scrap.repository;

import com.project.jobis.scrap.doamin.TaxAccountant;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxRepository extends JpaRepository<TaxAccountant, Long> {

    List<TaxAccountant> findByUserId(Long userId);
}