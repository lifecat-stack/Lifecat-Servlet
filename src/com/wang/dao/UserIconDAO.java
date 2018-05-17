package com.wang.dao;

public class UserIconDAO implements DAO {
    private UserIconDAO() {
    }

    static DAO newUserIconDAO() {
        return new UserIconDAO();
    }
}
