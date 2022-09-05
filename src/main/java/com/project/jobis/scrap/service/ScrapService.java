package com.project.jobis.scrap.service;

import com.project.jobis.scrap.controller.dto.ScrapRequest;
import java.util.Map;

public interface ScrapService {

    Map<String, Object> findAll(ScrapRequest scrapRequest, Long userId);
}
