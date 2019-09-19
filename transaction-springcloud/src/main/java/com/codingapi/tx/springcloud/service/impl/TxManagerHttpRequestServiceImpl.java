package com.codingapi.tx.springcloud.service.impl;

import com.codingapi.tx.netty.service.TxManagerHttpRequestService;
import com.lorne.core.framework.utils.http.HttpUtils;

public class TxManagerHttpRequestServiceImpl implements TxManagerHttpRequestService {
    @Override
    public String httpGet(String url) {
        return HttpUtils.get(url);
    }

    @Override
    public String httpPost(String url, String params) {
        return HttpUtils.post(url, params);
    }
}
