package com.wang.dao;

import com.wang.bean.UserMsg;

import java.sql.SQLException;

/**
 * usermsg表
 * <p>
 * 查询: 根据id查询usermsg
 * 更新: 更新(usermsg)到(id)中
 * 上传头像: 插入/更新(icon)到(id)中
 *
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

   public void selectUserMsg(){

   }
}
