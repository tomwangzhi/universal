package com.universal.client.fallback;

import com.universal.client.UserClient;
import com.universal.model.user.AppUser;
import com.universal.vo.ResponseApi;
import com.universal.vo.ResponseVo;
import org.springframework.stereotype.Component;

/**
 * @author YIJIUE
 */
@Component
public class UserClientFallback implements UserClient{

    @Override
    public ResponseVo<AppUser> getUserByName(String username) {
        return ResponseApi.fail("用户服务降级");
    }
}
