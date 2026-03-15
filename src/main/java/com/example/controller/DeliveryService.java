package com.example.controller;

import com.example.test.RateLimitCache;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

    @Autowired
    private RateLimitCache rateLimitCache;


    public Integer checkRateLimit(String webhookUrl) {

        Integer limit = rateLimitCache.getLimit(webhookUrl);
        System.out.println("Final output : " + rateLimitCache.getAll());

        System.out.println("Rate limit for " + webhookUrl + " = " + limit);

        return limit;
    }

}
