package com.wang.model;

import com.wang.bean.UserMsg;
import com.wang.dao.UserMsgDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
/**
 * @name GetMsgModel
 * @description 获取用户个人信息
 * @auther ten
 */
public class GetMsgModel extends MyModel {
    private UserMsg userMsg;
    private UserMsgDAO dao;

    public GetMsgModel(){
        dao=new UserMsgDAO();
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {

    }

    public UserMsg getUserMsg(int id) {
        userMsg=dao.queryUserMsg(id);
        return userMsg;
    }
}
