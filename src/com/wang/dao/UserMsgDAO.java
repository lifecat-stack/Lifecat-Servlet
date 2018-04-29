package com.wang.dao;

import com.wang.bean.UserMsg;

import java.sql.SQLException;

/**
 * @name UserMsgDAO
 * @description 根据用户id 查询/更新 usermsg
 * @auther ten
 */
public class UserMsgDAO extends BaseDAO implements DAO {
    /* 属性和数据库列名的映射 */
    private static final String nickname = "nickname";
    private static final String sex = "sex";
    private static final String age = "age";
    private static final String birthday = "birthday";
    private static final String email = "email";
    private static final String table = "usermsg";

    /**
     * @name queryUserMsg
     * @description 返回UserMsg的bean对象
     */
    public UserMsg queryUserMsg(int id) {
        UserMsg userMsg = new UserMsg();
        userMsg.setId(id);
        if (queryNickname(id)!=null) {
            userMsg.setNickname(queryNickname(id));
            userMsg.setSex(querySex(id));
            userMsg.setAge(queryAge(id));
            userMsg.setBirthday(queryBirthday(id));
            userMsg.setEmail(queryEmail(id));
        }
        else {
            userMsg.setNickname("未设置");
            userMsg.setSex("未设置");
            userMsg.setAge("未设置");
            userMsg.setBirthday("未设置");
            userMsg.setEmail("未设置");
        }
        return userMsg;
    }

    /* 查询单项：根据Id */
    public String queryNickname(int id) {
        String nick = null;
        try {
            nick = this.exeSelect(nickname, table, id).getString(nickname);
        } catch (SQLException e) {
            errorMsg(nickname);
            e.printStackTrace();
        }
        return nick;
    }

    /* 查询单项：根据Id */
    public String querySex(int id) {
        String se = null;
        try {
            se = this.exeSelect(sex, table, id).getString(sex);
        } catch (SQLException e) {
            errorMsg(sex);
            e.printStackTrace();
        }
        return se;
    }

    /* 查询单项：根据Id */
    public String queryAge(int id) {
        String ag = null;
        try {
            ag = this.exeSelect(age, table, id).getString(age);
        } catch (SQLException e) {
            errorMsg(age);
            e.printStackTrace();
        }
        return ag;
    }

    /* 查询单项：根据Id */
    public String queryBirthday(int id) {
        String bir = null;
        try {
            bir = this.exeSelect(birthday, table, id).getString(birthday);
        } catch (SQLException e) {
            errorMsg(birthday);
            e.printStackTrace();
        }
        return bir;
    }

    /* 查询单项：根据Id */
    public String queryEmail(int id) {
        String em = null;
        try {
            em = this.exeSelect(email, table, id).getString(email);
        } catch (SQLException e) {
            errorMsg(email);
            e.printStackTrace();
        }
        return em;
    }

    /**
     * @name insertUser
     * @description 新建一个User对象到数据库中
     */
    public boolean insertUser(UserMsg userMsg) {
        Object[] attributes = new Object[6];
        attributes[0] = userMsg.getId();
        attributes[1] = userMsg.getNickname();
        attributes[2] = userMsg.getSex();
        attributes[3] = userMsg.getAge();
        attributes[4] = userMsg.getBirthday();
        attributes[5] = userMsg.getEmail();
        return this.exeInsert(table, attributes);
    }
}
