package com.wang.dao;

import com.wang.bean.User;

import java.sql.*;

/**
 * @name UserDAO
 * @description 对user数据库进行操作
 * @auther ten
 */
public class UserDAO extends BaseDAO implements DAO {
    /* 属性和数据库列名的映射 */
    private static final String username = "name";
    private static final String password = "password";
    private static final String level = "level";
    private static final String table = "user";

    /**
     * @name queryUser
     * @description 返回User的bean对象
     */
    public User queryUser(int id) {
        User user = new User();
        user.setId(id);
        user.setName(queryUsername(id));
        user.setPassword(queryPassword(id));
        user.setLevel(queryLevel(id));
        return user;
    }

    /* 查询id:根据username生成HashCode */
    public int queryId(String username) {
        if (username==null){
            System.out.println("用户名为空！");
            return 0;
        }else {
            return username.hashCode();
        }
    }

    /* 查询username:根据id */
    public String queryUsername(int id) {
        String name = null;
        name = getString(id, name, username);
        return name;
    }

    /* 查询password:根据id */
    public String queryPassword(int id) {
        String psw = null;
        psw = getString(id, psw, password);
        return psw;
    }

    /* 查询level:根据id */
    public String queryLevel(int id) {
        String lel = null;
        lel = getString(id, lel, level);
        return lel;
    }

    /* 获取结果集对应的字段 */
    private String getString(int id, String str, String table_name) {
        try {
            ResultSet resultSet=this.exeSelect(table_name, table, id);
            resultSet.next();
            str = resultSet.getString(table_name);
        } catch (SQLException e) {
            errorMsg(table_name);
            e.printStackTrace();
        }
        return str;
    }

    /**
     * @name insertUser
     * @description 新建一个User对象到数据库中
     */
    public boolean insertUser(User user) {
        Object[] attributes = new Object[4];
        attributes[0] = user.getId();
        attributes[1] = user.getName();
        attributes[2] = user.getPassword();
        attributes[3] = user.getLevel();
        return this.exeInsert(table, attributes);
    }

    /* 更新密码 */
    public void updatePassword(String newpassword, int id) {
        boolean success;
        success = this.exeUpdate(table, password, newpassword, id);
        if (success) {
            System.out.println("更新密码成功");
        } else {
            System.out.println("更新密码失败");
        }
    }
}