package com.wang.daoimpl;

public class UserIconDAO implements DAO {
    private UserIconDAO() {
    }

    static DAO newUserIconDAO() {
        return new UserIconDAO();
    }
}
