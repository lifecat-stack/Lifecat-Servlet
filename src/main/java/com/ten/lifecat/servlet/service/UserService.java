package com.ten.lifecat.servlet.service;

import com.ten.lifecat.servlet.entity.User;

public interface UserService {

    /* ?????? */

    boolean isUserExisted(String userName);

    int insertUserToDatabase(User user);



}
