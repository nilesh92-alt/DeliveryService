package com.example.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DeliveryController {

//    private final DeliveryService deliveryService;

    private final Flow2RateLimitingService flow2RateLimitingService;

//    @GetMapping("/getLimitDelivery")
//    public int getLimitDelivery(@RequestParam String webhookUrl) {
//        return deliveryService.checkRateLimit(webhookUrl);
//    }

    @GetMapping("/limit")
    public void rateLimit(@RequestParam String webhookUrl) {
        if (flow2RateLimitingService.shouldSend(webhookUrl) == Decision.OK_TO_SEND) {
            System.out.println("Allow request");
        } else {
            System.out.println("Dont allow current request");
        }
    }
}
