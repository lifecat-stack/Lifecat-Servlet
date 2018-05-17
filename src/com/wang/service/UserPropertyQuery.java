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
 * UserPropertyQuery: 获取用户信息
 * <p>
 * 访问范围: 全局
 * 调用者: Servlet
 * 异常检测: try-catch异常处理层
 * <p>
 * 1. 获取DAOModel
 * 2. 获取usermsg
 * 3. 设置Session usermsg
 *
 * @auther ten
 */
class UserPropertyQuery implements Service {

    private Logger logger;

    private UserPropertyQuery() {
        logger = Logger.getLogger("UserPropertyQuery");
    }

    static Service getModel() {
        return new UserPropertyQuery();
    }

    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {

        User user = (User) req.getSession().getAttribute("user");

        UserMsgDAOModel daoModel = (UserMsgDAOModel) DAOModelFactory.getDAOModelByName(user.getId(), "UserMsgDAOModel");

        UserMsg msg;

        try {
            msg = daoModel.queryUserMsg();
        } catch (NullPointerException e) {
            e.printStackTrace();
            return new ServiceResult.Builder(true).errormsg("usermsg in database is null").page(HOST.PAGE_USERHOME).build();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ServiceResult.Builder(true).errormsg("SQLException").page(HOST.PAGE_USERHOME).build();
        }

        //若数据库中msg==null, 设置msg为默认
        if (msg == null) {
            msg = new UserMsg.Builder(user.getId()).build();
            logger.info(msg.toString());
            req.getSession().setAttribute("usermsg", msg);
            return new ServiceResult.Builder(true).errormsg("usermsg is null").page(HOST.PAGE_USERHOME).build();
        }

        //success
        logger.info(msg.toString());
        req.getSession().setAttribute("usermsg", msg);
        return new ServiceResult.Builder(false).page(HOST.PAGE_USERHOME).build();
    }
}