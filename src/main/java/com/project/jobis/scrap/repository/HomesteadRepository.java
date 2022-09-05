package com.project.jobis.scrap.repository;

import com.project.jobis.scrap.doamin.Homestead;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomesteadRepository extends JpaRepository<Homestead, Long> {

    List<Homestead> findByUserId(Long userId);

}