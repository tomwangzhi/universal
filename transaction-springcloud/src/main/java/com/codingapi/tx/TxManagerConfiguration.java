package com.codingapi.tx;

import com.codingapi.tx.config.service.TxManagerTxUrlService;
import com.codingapi.tx.netty.service.TxManagerHttpRequestService;
import com.codingapi.tx.springcloud.service.impl.TxManagerHttpRequestServiceImpl;
import com.codingapi.tx.springcloud.service.impl.TxManagerTxUrlServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author YIJIUE
 */
@Configuration
public class TxManagerConfiguration {
    @Bean
    public TxManagerTxUrlService txManagerTxUrlService(){
        return new TxManagerTxUrlServiceImpl();
    }

    @Bean
    public TxManagerHttpRequestService txManagerHttpRequestService(){
        return new TxManagerHttpRequestServiceImpl();
    }
}
