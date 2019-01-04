package com.ten.lifecat.servlet.dao;

import com.ten.lifecat.servlet.entity.UserIcon;

import java.util.List;

public interface UserIconDao {

    int insert(UserIcon pojo);

    int insertList(List<UserIcon> pojo);

    List<UserIcon> select(UserIcon pojo);

    int update(UserIcon pojo);

}
