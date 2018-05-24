package com.wang.service.serviceimpl;

import com.wang.constant.HOST;
import com.wang.dao.dao.DAOFactory;
import com.wang.dao.dao.UserPropertyDAO;
import com.wang.dao.jdbcimpl.JdbcDAOFactory;
import com.wang.bean.doo.UserPropertyDO;
import com.wang.bean.dto.UserDTO;
import com.wang.service.service.Service;
import com.wang.util.MyDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * UserPropertyUpdate: 更新用户信息
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
class UserPropertyUpdate implements Service {

    private Logger logger = LoggerFactory.getLogger(UserPropertyUpdate.class);

    private UserPropertyUpdate() {
    }

    static Service newService() {
        return new UserPropertyUpdate();
    }
    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {
        UserDTO userDTO = (UserDTO) req.getSession().getAttribute("user");
        Integer userId = userDTO.getUserId();

        String nickname = req.getParameter("nickname");
        String signature = req.getParameter("signature");
        String sex = req.getParameter("sex");
        String email = req.getParameter("email");
        String location = req.getParameter("location");
        String birthday = req.getParameter("birthday");

        String dateTime = MyDate.getInstance().getCurrentTime();

        // 将图片信息写入数据库
        // 获取DAO实例
        DAOFactory factory = new JdbcDAOFactory();
        UserPropertyDAO dao = factory.getUserPropertyDAO();

        UserPropertyDO userPropertyDO = new UserPropertyDO();
        userPropertyDO.setUserId(userId);
        userPropertyDO.setPropertyNickname(nickname);
        userPropertyDO.setPropertySignature(signature);
        userPropertyDO.setPropertySex(sex);
        userPropertyDO.setPropertyEmail(email);
        userPropertyDO.setPropertyLocation(location);
        userPropertyDO.setPropertyBirthday(birthday);
        userPropertyDO.setPropertyGmtCreate(dateTime);
        userPropertyDO.setPropertyGmtModified(dateTime);

        boolean success2 = false;
        try {
            dao.insertUserProperty(userPropertyDO);
            success2 = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (!success2) {
            return new ServiceResult.Builder(false)
                    .errormsg("数据库插入异常")
                    .page(req.getRequestURI())
                    .build();
        }

        return new ServiceResult.Builder(true)
                .page(HOST.PAGE_USERHOME)
                .build();
    }
}