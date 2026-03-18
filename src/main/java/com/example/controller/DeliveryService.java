package com.example.controller;

import com.example.rateLimiting.RatelimitingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

    @Autowired
    private RatelimitingService ratelimitingService;

    @Autowired
    private CacheInspector cacheInspector;

    public Integer checkRateLimit(String webhookUrl) {

        Integer limit = ratelimitingService.getLimit(webhookUrl);
        System.out.println("Rate limit for " + webhookUrl + " = " + limit);
        cacheInspector.printCacheEntries();
        return limit;
    }

}
