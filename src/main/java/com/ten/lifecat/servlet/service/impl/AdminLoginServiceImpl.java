package com.ten.lifecat.servlet.service.impl;

import com.ten.lifecat.servlet.entity.Admin;
import com.ten.lifecat.servlet.entity.AdminVO;
import com.ten.lifecat.servlet.constant.Page;
import com.ten.lifecat.servlet.dao.JdbcDAOFactory;
import com.ten.lifecat.servlet.constant.Page;
import com.ten.lifecat.servlet.service.AdminLoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * 管理员登录
 *
 * @date 2018/5/24
 * @auther ten
 */
public class AdminLoginServiceImpl implements AdminLoginService {
    private static final Logger logger = LoggerFactory.getLogger(AdminLoginServiceImpl.class);
    private static final AdminDAO DAO = (AdminDAO) JdbcDAOFactory.getDaoByTableName("admin");

    public AdminLoginServiceImpl() {
    }

    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {
        String adminName = req.getParameter("adminName");
        String adminPassword = req.getParameter("adminPassword");

        Admin adminDO = queryAdminByName(adminName);

        // 管理员不存在
        if (adminDO == null) {
            return new ServiceResult.Builder(false)
                    .page(Page.PAGE_INDEX)
                    .errormsg("该管理员不存在")
                    .build();
        }

        // 管理员密码错误
        if (!adminPassword.equals(adminDO.getAdminPassword())) {
            return new ServiceResult.Builder(false)
                    .page(Page.PAGE_INDEX)
                    .errormsg("管理员密码错误")
                    .build();
        }

        // SUCCESS
        AdminVO adminVO = new AdminVO(
                adminDO.getId(),
                adminDO.getAdminName(),
                adminDO.getAdminLevel());

        req.getSession().setAttribute("admin", adminVO);
        return new ServiceResult.Builder(true)
                .page(Page.PAGE_USERHOME)
                .build();
    }

    @Override
    public Admin queryAdminByName(String adminName) {
        try {
            return DAO.queryAdmin(adminName);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean isAdminExisted(String adminName) {
        return true;
    }
}
