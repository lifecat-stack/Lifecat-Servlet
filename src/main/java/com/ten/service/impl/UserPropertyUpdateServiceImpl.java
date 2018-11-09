package com.ten.service.impl;

import com.ten.bean.entity.UserProperty;
import com.ten.bean.vo.UserVO;
import com.ten.constant.Page;
import com.ten.dao.DAOFactory;
import com.ten.dao.UserPropertyDAO;
import com.ten.dao.JdbcDAOFactory;
import com.ten.service.UserPropertyUpdateService;
import com.ten.util.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * 用户资料更新
 * <p>
 * 失败 Page.PAGE_USERHOME
 * 成功 Page.PAGE_USERHOME
 *
 * @date 2018/5/24
 * @auther ten
 */
public class UserPropertyUpdateServiceImpl implements UserPropertyUpdateService {

    private Logger logger = LoggerFactory.getLogger(UserPropertyUpdateServiceImpl.class);

    private UserPropertyDAO dao;

    public UserPropertyUpdateServiceImpl() {
        DAOFactory factory = new JdbcDAOFactory();
        dao = (UserPropertyDAO) factory.getDaoByTableName("user_property");
    }

    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {

        UserVO userDTO = (UserVO) req.getSession().getAttribute("user");
        Integer userId = userDTO.getUserId();

        String nickname = req.getParameter("nickname");
        String signature = req.getParameter("signature");
        String sex = req.getParameter("sex");
        String email = req.getParameter("email");
        String location = req.getParameter("location");
        String birthday = req.getParameter("birthday");

        String dateTime = DateTimeUtil.getInstance().getCurrentTime();

        UserProperty userProperty = new UserProperty();
        userProperty.setUserId(userId);
        userProperty.setPropertyNickname(nickname);
        userProperty.setPropertySignature(signature);
        userProperty.setPropertySex(sex);
        userProperty.setPropertyEmail(email);
        userProperty.setPropertyLocation(location);
        userProperty.setPropertyBirthday(birthday);
        userProperty.setPropertyGmtCreate(dateTime);
        userProperty.setPropertyGmtModified(dateTime);

        updateUserProperty(userProperty);

        return new ServiceResult.Builder(true).page(Page.PAGE_USERHOME).build();
    }

    @Override
    public void updateUserProperty(UserProperty userProperty) {
        try {
            dao.insertUserProperty(userProperty);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}