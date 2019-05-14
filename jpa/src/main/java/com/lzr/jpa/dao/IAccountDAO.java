package com.lzr.jpa.dao;



import com.lzr.jpa.bean.Account;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IAccountDAO  extends JpaRepository<Account, Integer> {

}
