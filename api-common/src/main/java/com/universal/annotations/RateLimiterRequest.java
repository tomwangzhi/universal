package com.universal.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

/**
 * 服务限流公共类
 * @author YIJIUE
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface RateLimiterRequest {
    // 限制服务访问量 默认每秒最多三次
    int qps() default 3;

    // 超时等待时间
    int timeout() default 2;

    // 服务降级输出语句
    String message() default "system error";

    // 设置超时时间单位
    TimeUnit time() default TimeUnit.SECONDS;
}
