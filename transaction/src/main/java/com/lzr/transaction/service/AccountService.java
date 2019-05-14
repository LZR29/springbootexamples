package com.lzr.transaction.service;

import com.lzr.transaction.dao.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @authoor linzerong
 * @create 2019-05-14 23:00
 */
@Service
public class AccountService {
    @Autowired
    private AccountMapper accountService;

    @Transactional
    public void transfer() throws RuntimeException{
        accountService.update(90,1);//用户1减10块 用户2加10块
        int i=1/0;
        accountService.update(110,2);
    }

}
