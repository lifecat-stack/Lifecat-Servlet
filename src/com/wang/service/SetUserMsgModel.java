package com.wang.service;

import com.wang.bean.User;
import com.wang.bean.UserMsg;
import com.wang.daomanager.DAOModelFactory;
import com.wang.daomanager.UserMsgDAOModel;
import com.wang.util.HOST;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * SetUserMsgModel: 更新用户信息
 * <p>
 * 访问范围: 全局
 * 调用者: Servlet
 * 异常检测: try-catch异常处理层
 * <p>
 * 1. 获取DAOModel
 * 2. 更新Usermsg
 *
 * @auther ten
 */
class SetUserMsgModel implements ServiceModel {

    private Logger logger;

    private SetUserMsgModel() {
        logger = Logger.getLogger("SetUserMsgModel");
    }

    static ServiceModel getModel() {
        return new SetUserMsgModel();
    }

    @Override
    public ModelResult execute(HttpServletRequest req, HttpServletResponse resp) {

        String nickname = req.getParameter("nickname");
        String sex = req.getParameter("sex");
        String age = req.getParameter("age");
        String birthday = req.getParameter("birthday");
        String email = req.getParameter("email");

        logger.info("nickname " + nickname);
        logger.info("sex " + sex);
        logger.info("age " + age);
        logger.info("birthday " + birthday);
        logger.info("email " + email);

        User user = (User) req.getSession().getAttribute("user");

        UserMsg msg = new UserMsg.Builder(user.getId()).nickname(nickname).age(age)
                .sex(sex).birthday(birthday).email(email).build();

        UserMsgDAOModel daoModel = (UserMsgDAOModel) DAOModelFactory.getDAOModelByName(user.getId(), "UserMsgDAOModel");

        try {
            //插入usermsg
            daoModel.insertUserMsg(msg);

            //更新usermsg
            msg = daoModel.queryUserMsg();
        }/*
         * 更新异常:
         *
         * 1. 返回错误信息
         * 2. 跳转page: userhome
         */ catch (IllegalArgumentException e) {
            e.printStackTrace();
            return new ModelResult.Builder(true).errormsg("usermsg argument has null").page(HOST.PAGE_USERHOME).build();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ModelResult.Builder(true).errormsg("SQLException").page(HOST.PAGE_USERHOME).build();
        }

        /*
         * 更新成功:
         *
         * 1. 设置Session: usermsg
         * 2. 跳转page: userhome
         */
        req.getSession().setAttribute("usermsg", msg);
        return new ModelResult.Builder(false).page(HOST.PAGE_USERHOME).build();
    }
}