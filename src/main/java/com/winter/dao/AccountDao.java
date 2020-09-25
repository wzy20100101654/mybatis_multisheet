package com.winter.dao;

import com.winter.domain.Account;

import java.util.List;

public interface AccountDao {
    //查询所有账户
    List<Account> findAll();
}
