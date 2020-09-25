package com.winter.dao;

import com.winter.domain.User;

import java.util.List;

//用户持久层接口
public interface UserDao {
    //查询所有用户，同时得到其对应的所有账户信息
    List<User> findAll();
    //根据id查询用户
    User findById(Integer userId);
}
