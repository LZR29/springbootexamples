package com.lzr.jpa.controller;


import com.lzr.jpa.bean.Account;
import com.lzr.jpa.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @authoor linzerong
 * @create 2019-05-14 19:36
 */
@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private IAccountService accountService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Account> getAccounts(){
        return accountService.findAccountList();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Account getAccountById(@PathVariable("id") int id){
        return accountService.findAccountById(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public String updateAccount(@PathVariable("id") int id, @RequestParam("name") String name,
                                @RequestParam("money") double money){
        Account account = new Account();
        account.setId(id);
        account.setName(name);
        account.setMoney(money);
        String res = accountService.update(account);
        if(!res.isEmpty()){
            return res;
        }else {
            return "fail";
        }

    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public  String postAccount( @RequestParam(value = "name")String name,
                                @RequestParam(value = "money" )double money){
        Account account=new Account();
        account.setMoney(money);
        account.setName(name);
        String res = accountService.add(account);
        if(!res.isEmpty()){
            return res;
        }else {
            return "fail";
        }

    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") int id){
        accountService.delete(id);
        return "ok";
    }
}
