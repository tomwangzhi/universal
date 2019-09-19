package com.universal.controller;

import com.universal.client.TicketClient;
import com.universal.model.user.AppUser;
import com.universal.service.UserService;
import com.universal.vo.ResponseApi;
import com.universal.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author YIJIUE
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TicketClient ticketClient;

    @GetMapping("/user/access/{username}")
    public ResponseVo getUser(@PathVariable("username") String username) {
        AppUser appUser = userService.getUser(username);
        //Thread.sleep(5000);
        return ResponseApi.returnData(appUser);
    }

    @GetMapping("/api/v1/me")
    public String show(){
        return "ok";
    }

    @GetMapping("/api/v1/ticket")
    public String get(){
        String ticket = ticketClient.get();
        return ticket;
    }

}
