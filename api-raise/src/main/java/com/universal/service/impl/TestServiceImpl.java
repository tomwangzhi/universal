package com.universal.service.impl;

import com.codingapi.tx.annotation.TxTransaction;
import com.universal.client.TestClient;
import com.universal.dao.TestDao;
import com.universal.service.TestService;
import com.universal.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestDao testDao;

    @Autowired
    private TestClient testClient;

    @Override
    @Transactional
    @TxTransaction(isStart = true)
    public int saveInfo() {

        testClient.updateTicket();
        testDao.save("增加众筹人员");
        int i = 1 / 0;

        return i;
    }
}
