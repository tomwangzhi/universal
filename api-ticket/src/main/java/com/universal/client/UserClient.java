package com.universal.client;

import com.universal.client.fallback.fallback;
import com.universal.model.user.AppUser;
import com.universal.vo.ResponseVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "api-user", fallback = fallback.class)
public interface UserClient {

    @GetMapping("/api/v1/user/{username}")
    public ResponseVo<AppUser> getUser(@PathVariable("username") String name);
}
