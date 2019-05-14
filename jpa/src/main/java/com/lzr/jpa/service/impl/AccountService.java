package com.lzr.jpa.service.impl;



import com.lzr.jpa.bean.Account;
import com.lzr.jpa.dao.IAccountDAO;
import com.lzr.jpa.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @authoor linzerong
 * @create 2019-05-14 19:34
 */
@Service
public class AccountService implements IAccountService {

    @Autowired
    private IAccountDAO accountDAO;

    @Override
    public String add(Account account) {
        return accountDAO.save(account).toString();
    }

    @Override
    public String update(Account account) {
        return accountDAO.saveAndFlush(account).toString();
    }

    @Override
    public void delete(int id) {
         accountDAO.deleteById(id);
    }

    @Override
    public Account findAccountById(int id) {
        Optional<Account> optional = accountDAO.findById(id);
        if(optional.isPresent()){
            Account account = optional.get();
            return account;
        }else {
            return null;
        }

    }

    @Override
    public List<Account> findAccountList() {
        return accountDAO.findAll();
    }
}
