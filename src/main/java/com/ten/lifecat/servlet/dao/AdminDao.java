package com.ten.lifecat.servlet.dao;

import com.ten.lifecat.servlet.entity.Admin;

import java.util.List;

public interface AdminDao extends BaseDao<Admin> {

    @Override
    int insert(Admin pojo) ;

    @Override
    List<Admin> select(Admin pojo)  ;

    @Override
    int update(Admin pojo)  ;

    @Override
    int delete(Admin pojo)  ;

}
