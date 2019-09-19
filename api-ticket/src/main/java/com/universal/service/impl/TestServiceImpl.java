package com.universal.service.impl;

import com.codingapi.tx.annotation.TxTransaction;
import com.universal.dao.TestDao;
import com.universal.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    @Override
    @Transactional
    @TxTransaction
    public int updateTicket() {
        return testDao.updateTicket();
    }
}
