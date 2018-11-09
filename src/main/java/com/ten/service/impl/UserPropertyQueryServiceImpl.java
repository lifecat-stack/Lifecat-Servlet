package com.ten.service.impl;

import com.ten.bean.entity.UserProperty;
import com.ten.bean.vo.UserPropertyVO;
import com.ten.constant.Page;
import com.ten.constant.WEBINF;
import com.ten.dao.DAOFactory;
import com.ten.dao.UserIconDAO;
import com.ten.dao.UserPropertyDAO;
import com.ten.dao.JdbcDAOFactory;
import com.ten.service.UserPropertyQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * 查询用户资料
 * <p>
 * 失败 com.ten.constant.WEBINF.USER
 * 成功 com.ten.constant.WEBINF.USER
 *
 * @date 2018/5/24
 * @auther ten
 */
public class UserPropertyQueryServiceImpl implements UserPropertyQueryService {

    private Logger logger = LoggerFactory.getLogger(UserPropertyQueryServiceImpl.class);

    private UserPropertyDAO propertyDAO;
    private UserIconDAO iconDAO;

    public UserPropertyQueryServiceImpl() {
        DAOFactory factory = new JdbcDAOFactory();
        propertyDAO = (UserPropertyDAO) factory.getDaoByTableName("user_property");
        iconDAO = (UserIconDAO) factory.getDaoByTableName("user_icon");
    }

    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {

        Integer userId = Integer.valueOf(req.getParameter("userId"));

        UserProperty userProperty = queryUserProperty(userId);
        if (userProperty == null) {
            return new ServiceResult.Builder(false).errormsg("用户信息不存在").page(WEBINF.USER).build();
        }

        String userIconPath = queryUserIcon(userId);

        UserPropertyVO userPropertyVO = new UserPropertyVO(userId)
                .nickname(userProperty.getPropertyNickname())
                .signature(userProperty.getPropertySignature())
                .sex(userProperty.getPropertySex())
                .email(userProperty.getPropertyEmail())
                .birthday(userProperty.getPropertyBirthday())
                .location(userProperty.getPropertyLocation())
                .iconPath(userIconPath);

        req.getSession().setAttribute("userProperty", userPropertyVO);
        return new ServiceResult.Builder(true).page(Page.PAGE_USERHOME).build();
    }

    @Override
    public UserProperty queryUserProperty(int userId) {
        try {
            return propertyDAO.queryUserProperty(userId);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String queryUserIcon(int userId) {
        try {
            return iconDAO.queryUserIcon(userId);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}