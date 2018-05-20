package com.wang.daoimpl;

import com.wang.dao.DAO;

public class UserIconDAO implements DAO {
    private UserIconDAO() {
    }

    static DAO newUserIconDAO() {
        return new UserIconDAO();
    }
}
