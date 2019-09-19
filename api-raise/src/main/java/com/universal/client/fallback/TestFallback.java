package com.universal.client.fallback;

import com.universal.client.TestClient;
import com.universal.vo.ResponseApi;
import com.universal.vo.ResponseVo;
import org.springframework.stereotype.Component;

@Component
public class TestFallback implements TestClient {
    @Override
    public ResponseVo updateTicket() {
        return ResponseApi.fail("lcn test fail");
    }
}
