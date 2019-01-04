package com.ten.lifecat.servlet.dao;

import com.ten.lifecat.servlet.entity.User;

import java.util.List;

public interface UserDao {

    int insert(User pojo);

    int insertList(List<User> pojo);

    List<User> select(User pojo);

    int update(User pojo);

}
