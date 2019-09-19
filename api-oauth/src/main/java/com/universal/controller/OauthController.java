package com.universal.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 当前认证用户类
 * @author YIJIUE
 */
@RestController
public class OauthController {

    @GetMapping("/user-me")
    public Authentication principal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication;
    }

}
