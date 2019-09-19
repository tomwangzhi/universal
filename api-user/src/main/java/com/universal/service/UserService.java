package com.universal.service;

import com.universal.model.user.AppUser;

/**
 * @author YIJIUE
 */
public interface UserService {

    /**
     * 根据账户名查找用户
     * @param username
     * @return
     */
    public AppUser getUser(String username);
}
