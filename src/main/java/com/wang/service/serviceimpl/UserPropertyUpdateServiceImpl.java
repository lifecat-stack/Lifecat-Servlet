package com.wang.service.serviceimpl;

import com.wang.bean.doo.UserPropertyDO;
import com.wang.bean.dto.UserDTO;
import com.wang.constant.Page;
import com.wang.dao.DAOFactory;
import com.wang.dao.dao.UserPropertyDAO;
import com.wang.dao.jdbcimpl.JdbcDAOFactory;
import com.wang.service.Service;
import com.wang.util.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * 用户资料更新
 *
 * 失败 Page.PAGE_USERHOME
 * 成功 Page.PAGE_USERHOME
 *
 * @date 2018/5/24
 * @auther ten
 */
class UserPropertyUpdateServiceImpl implements UserPropertyUpdateService {

    private Logger logger = LoggerFactory.getLogger(UserPropertyUpdateServiceImpl.class);

    private UserPropertyUpdateServiceImpl() {
    }

    static Service newService() {
        return new UserPropertyUpdateServiceImpl();
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

        String dateTime = DateTimeUtil.getInstance().getCurrentTime();

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
                    .page(Page.PAGE_USERHOME)
                    .build();
        }

        return new ServiceResult.Builder(true)
                .page(Page.PAGE_USERHOME)
                .build();
    }
}