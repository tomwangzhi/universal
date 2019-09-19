package com.universal.controller;

import com.universal.annotations.RateLimiterRequest;
import com.universal.service.TestService;
import com.universal.vo.ResponseApi;
import com.universal.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@RestController
public class LCNTestController {
    @Autowired
    private TestService testService;

    @RateLimiterRequest(qps = 2, message = "The server is busy, please try again later")
    @GetMapping("/")
    public ResponseVo test(){
        try {
            int i = testService.saveInfo();
            if (i > 0) {
                return ResponseApi.success();
            }
        } catch (Exception e){
            return ResponseApi.fail("服务异常");
        }
        return ResponseApi.fail("余票不足");
    }

}
