package com.universal.controller;

import com.universal.client.UserClient;
import com.universal.dao.TestDao;
import com.universal.model.user.AppUser;
import com.universal.service.TestService;
import com.universal.vo.ResponseApi;
import com.universal.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Set;

@RestController
public class TestController {

    @Autowired
    private UserClient userClient;

    @Autowired
    private TestService testService;


    @GetMapping("/user")
    public AppUser user(){
        ResponseVo<AppUser> admin = userClient.getUser("17817559006");
        AppUser user = (AppUser) admin.getData();
        return user;
    }

    @PutMapping("/update/ticket")
    public ResponseVo save(){
        int i = testService.updateTicket();
        if (i > 0){
            return ResponseApi.success();
        }
        return ResponseApi.fail("error");
    }

    @GetMapping("/api/v1/test")
    public String get(){
       return "ok";
    }
}
