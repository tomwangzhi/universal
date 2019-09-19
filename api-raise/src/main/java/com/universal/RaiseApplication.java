package com.universal;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author YIJIUE
 */
@EnableFeignClients
@SpringCloudApplication
public class RaiseApplication {
    public static void main(String[] args) {
        SpringApplication.run(RaiseApplication.class, args);
    }
}
