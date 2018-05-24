package com.wang.service.serviceimpl;

import com.wang.constant.HOST;
import com.wang.dao.dao.DAOFactory;
import com.wang.dao.dao.UserIconDAO;
import com.wang.dao.dao.UserPropertyDAO;
import com.wang.dao.jdbcimpl.JdbcDAOFactory;
import com.wang.bean.doo.UserPropertyDO;
import com.wang.bean.dto.UserDTO;
import com.wang.bean.dto.UserPropertyDTO;
import com.wang.service.service.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

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

   private Logger logger = LoggerFactory.getLogger(UserPropertyQuery.class);

    private UserPropertyQuery() {
    }

    static Service newService() {
        return new UserPropertyQuery();
    }
    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {

        UserDTO userDTO = (UserDTO) req.getSession().getAttribute("user");
        Integer userId = userDTO.getUserId();

        DAOFactory factory = new JdbcDAOFactory();
        UserPropertyDAO propertyDAO = factory.getUserPropertyDAO();
        UserIconDAO iconDAO = factory.getUserIconDAO();

        UserPropertyDO userPropertyDO = null;
        String userIconPath = null;
        boolean success = false;
        try {
            userPropertyDO = propertyDAO.queryUserProperty(userId);
            userIconPath = iconDAO.queryUserIcon(userId);
            success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (!success) {
            return new ServiceResult.Builder(false)
                    .errormsg("数据库查询异常").page(req.getRequestURI()).build();
        }

        if (userPropertyDO == null && userIconPath == null) {
            return new ServiceResult.Builder(false)
                    .errormsg("用户信息为空").page(req.getRequestURI()).build();
        }

        assert userPropertyDO != null;
        UserPropertyDTO userPropertyDTO = new UserPropertyDTO.Builder(userId)
                .nickname(userPropertyDO.getPropertyNickname())
                .signature(userPropertyDO.getPropertySignature())
                .sex(userPropertyDO.getPropertySex())
                .email(userPropertyDO.getPropertyEmail())
                .birthday(userPropertyDO.getPropertyBirthday())
                .location(userPropertyDO.getPropertyLocation())
                .iconPath(userIconPath)
                .build();

        req.getSession().setAttribute("userProperty", userPropertyDTO);
        return new ServiceResult.Builder(true).page(HOST.PAGE_USERHOME).build();
    }
}