package com.lzr.transaction.controller;

import com.lzr.transaction.service.AccountService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @authoor linzerong
 * @create 2019-05-14 23:06
 */
@RestController
@RequestMapping("/account")
@MapperScan("com.lzr.transaction.dao")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/transfer", method = RequestMethod.GET)
    public String transfer(){
        try {
            accountService.transfer();
        }catch (Exception e){
            return "transaction rollback";
        }
        return "success";
    }
}
