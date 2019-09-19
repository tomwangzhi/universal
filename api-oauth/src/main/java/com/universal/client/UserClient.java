package com.universal.client;

import com.universal.client.fallback.UserClientFallback;
import com.universal.model.user.AppUser;
import com.universal.vo.ResponseVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author YIJIUE
 */
@FeignClient(name = "api-user", fallback = UserClientFallback.class)
public interface UserClient {

    @GetMapping("/user/access/{username}")
    ResponseVo<AppUser> getUserByName(@PathVariable("username") String username);

}
