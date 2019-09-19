package com.universal.service.impl;

import com.universal.client.UserClient;
import com.universal.config.custom.CustomUserDetail;
import com.universal.model.user.AppUser;
import com.universal.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * oauth查找用户实现类
 */
@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private UserClient userClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ResponseVo<AppUser> data = userClient.getUserByName(username);
        if (data.getData() == null) {
            throw new UsernameNotFoundException(String.format("User %s does not exist!", username));
        }
        AppUser user = (AppUser) data.getData();
        return new CustomUserDetail(user);
    }

}
