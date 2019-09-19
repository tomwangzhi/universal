package com.universal.client.fallback;

import com.universal.client.UserClient;
import com.universal.vo.ResponseApi;
import com.universal.vo.ResponseVo;
import org.springframework.stereotype.Component;

@Component
public class fallback implements UserClient {
    @Override
    public ResponseVo getUser(String name) {
        return ResponseApi.fail("123");
    }
}
