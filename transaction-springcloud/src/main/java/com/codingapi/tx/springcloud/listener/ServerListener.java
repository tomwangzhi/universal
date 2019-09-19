package com.codingapi.tx.springcloud.listener;

import com.codingapi.tx.listener.service.InitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


@Component
public class ServerListener implements ApplicationListener {

    private Logger logger = LoggerFactory.getLogger(ServerListener.class);

    @Value("${server.port}")
    private int serverPort;

    @Autowired
    private InitService initService;

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        //logger.info("onApplicationEvent -> onApplicationEvent. "+event.getEmbeddedServletContainer());
        //this.serverPort = event.getEmbeddedServletContainer().getPort();
        logger.info("init lcn-springcloud start");
        initService.start();
    }

    public int getPort() {
        return this.serverPort;
    }
}
