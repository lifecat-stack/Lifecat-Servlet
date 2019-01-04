package com.ten.lifecat.servlet.dao;

import com.ten.lifecat.servlet.entity.UserProperty;

import java.util.List;

public interface UserPropertyDao {

    int insert(UserProperty pojo);

    int insertList(List<UserProperty> pojo);

    List<UserProperty> select(UserProperty pojo);

    int update(UserProperty pojo);

}
