package com.codingapi.tm.listener;

import com.codingapi.tm.Constants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * create by lorne on 2017/8/7
 */
@Component
public class ApplicationStartListener implements ApplicationListener {

    @Value("${server.port}")
    private int port;

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        String ip = getIp();
        Constants.address = ip+":"+port;
    }



    private String getIp(){
        String host = null;
        try {
            host = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return host;
    }
}
