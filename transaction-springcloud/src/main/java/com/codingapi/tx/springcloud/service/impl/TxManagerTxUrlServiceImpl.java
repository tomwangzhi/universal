package com.codingapi.tx.springcloud.service.impl;

import com.codingapi.tx.config.service.TxManagerTxUrlService;
import org.springframework.beans.factory.annotation.Value;

public class TxManagerTxUrlServiceImpl implements TxManagerTxUrlService {

    @Value("${tm.manager.url}")
    private String url;

    @Override
    public String getTxUrl() {
        return url;
    }
}
