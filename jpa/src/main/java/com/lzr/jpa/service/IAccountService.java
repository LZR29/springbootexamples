package com.lzr.jpa.service;



import com.lzr.jpa.bean.Account;

import java.util.List;

public interface IAccountService {
    String add(Account account);

    String update(Account account);

    void delete(int id);

    Account findAccountById(int id);

    List<Account> findAccountList();
}
