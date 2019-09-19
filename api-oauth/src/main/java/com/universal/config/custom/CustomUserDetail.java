package com.universal.config.custom;

import com.universal.model.user.AppUser;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

/**
 * 自定义账户
 * @author YIJIUE
 */
public class CustomUserDetail extends User {

    public CustomUserDetail(AppUser appUser) {
        super(appUser.getUsername(), appUser.getPassword(), appUser.getEnabled(), true, true, true, AuthorityUtils.NO_AUTHORITIES);
    }

}
