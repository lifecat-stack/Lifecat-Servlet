package com.ten.lifecat.servlet.entity;

import com.ten.lifecat.servlet.dao.UserIconDao;

import javax.annotation.Resource;
import java.util.List;

public class UserIconService {

    @Resource
    private UserIconDao userIconDao;

    public int insert(UserIcon pojo){
        return userIconDao.insert(pojo);
    }

    public int insertList(List< UserIcon> pojos){
        return userIconDao.insertList(pojos);
    }

    public List<UserIcon> select(UserIcon pojo){
        return userIconDao.select(pojo);
    }

    public int update(UserIcon pojo){
        return userIconDao.update(pojo);
    }

}
