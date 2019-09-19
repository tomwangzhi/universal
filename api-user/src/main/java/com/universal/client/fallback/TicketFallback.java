package com.universal.client.fallback;

import com.universal.client.TicketClient;
import org.springframework.stereotype.Component;

import java.security.Principal;

@Component
public class TicketFallback implements TicketClient {
    @Override
    public String get() {
        return "服务不可用";
    }
}
