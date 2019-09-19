package com.universal.client;

import com.universal.client.fallback.TestFallback;
import com.universal.vo.ResponseVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(value = "api-ticket", fallback = TestFallback.class)
public interface TestClient {

    @PutMapping("/update/ticket")
    ResponseVo updateTicket();
}
