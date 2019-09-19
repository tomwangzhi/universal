package com.universal.service.impl;

import com.netflix.discovery.converters.Auto;
import com.universal.dao.UserMapper;
import com.universal.model.user.AppUser;
import com.universal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author YIJIUE
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public AppUser getUser(String username) {
        return userMapper.getUser(username);
    }
}
