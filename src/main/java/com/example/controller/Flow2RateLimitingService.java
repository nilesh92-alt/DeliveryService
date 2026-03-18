package com.example.controller;

import com.example.rateLimiting.PerCustomerRateLimiter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Flow2RateLimitingService {

    private final PerCustomerRateLimiter perCustomerRateLimiter;

    public Decision shouldSend(String outboundUrl) {
        return perCustomerRateLimiter.tryAcquire(outboundUrl) ? Decision.OK_TO_SEND : Decision.DONT_SEND;
    }
}
