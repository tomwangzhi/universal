package com.universal.aspect;

import com.google.common.util.concurrent.RateLimiter;
import com.universal.annotations.RateLimiterRequest;
import com.universal.vo.ResponseApi;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 简单访问限流
 * @author YIJIUE
 */
@Aspect
@Component
public class RateLimiterAspect {

    private RateLimiter rateLimiter = RateLimiter.create(100);

    @ResponseBody
    @Around("@annotation(rateLimiterRequest)")
    public Object handler(ProceedingJoinPoint pjp, RateLimiterRequest rateLimiterRequest) throws Throwable {
        int qps = rateLimiterRequest.qps();
        rateLimiter.setRate(qps);
        if (!rateLimiter.tryAcquire(rateLimiterRequest.timeout(), rateLimiterRequest.time())){
            return ResponseApi.fail(rateLimiterRequest.message());
        }
        return pjp.proceed();
    }

}
