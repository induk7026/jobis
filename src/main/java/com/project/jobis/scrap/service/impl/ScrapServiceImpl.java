package com.project.jobis.scrap.service.impl;

import com.project.jobis.exception.EntityNotFoundException;
import com.project.jobis.scrap.controller.dto.ScrapRequest;
import com.project.jobis.scrap.doamin.Company;
import com.project.jobis.scrap.doamin.Homestead;
import com.project.jobis.scrap.doamin.TaxAccountant;
import com.project.jobis.scrap.repository.CompanyRepository;
import com.project.jobis.scrap.repository.HomesteadRepository;
import com.project.jobis.scrap.repository.TaxRepository;
import com.project.jobis.scrap.service.ScrapService;
import com.project.jobis.user.repository.UserRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScrapServiceImpl implements ScrapService {

    private final CompanyRepository companyRepository;
    private final HomesteadRepository homesteadRepository;
    private final TaxRepository taxRepository;
    private final UserRepository userRepository;

    @Override
    public Map<String, Object> findAll(ScrapRequest scrapRequest, Long userId) {
        userRepository.findById(userId)
            .orElseThrow(EntityNotFoundException::new);

        Map<String, Object> map = new HashMap();
        List<Company> companyList = companyRepository.findByUserId(userId);
        List<Homestead> homesteadList = homesteadRepository.findByUserId(userId);
        List<TaxAccountant> taxList = taxRepository.findByUserId(userId);
        map.put("scrap001",companyList);
        map.put("scrap002",homesteadList);
        map.put("scrap003",taxList);
        map.put("scrap004",taxList);
        return map;
    }
}
