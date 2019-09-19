package com.universal.client;

import com.universal.client.fallback.TicketFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@FeignClient(value = "api-ticket", fallback = TicketFallback.class)
public interface TicketClient {

    @GetMapping("/api/v1/test")
    String get();
}
