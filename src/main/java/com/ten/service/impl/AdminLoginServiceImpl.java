package com.ten.service.impl;

import com.ten.bean.entity.AdminDO;
import com.ten.bean.vo.AdminVO;
import com.ten.constant.Page;
import com.ten.dao.AdminDAO;
import com.ten.dao.jdbcimpl.JdbcDAOFactory;
import com.ten.service.AdminLoginService;
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

    private AdminDAO dao;

    public AdminLoginServiceImpl() {
        dao = (AdminDAO) new JdbcDAOFactory().getDaoByTableName("admin");
    }

    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {

        String adminName = req.getParameter("adminName");
        String adminPassword = req.getParameter("adminPassword");

        AdminDO adminDO = queryAdminByName(adminName);

        if (adminDO == null) {
            return new ServiceResult.Builder(false).page(Page.PAGE_INDEX).errormsg("该管理员不存在").build();
        }

        if (!adminPassword.equals(adminDO.getAdminPassword())) {
            return new ServiceResult.Builder(false).page(Page.PAGE_INDEX).errormsg("密码错误").build();
        }

        AdminVO admin = new AdminVO(adminDO.getAdminId(), adminDO.getAdminName(), adminDO.getAdminLevel());
        req.getSession().setAttribute("admin", admin);
        return new ServiceResult.Builder(true).page(Page.PAGE_USERHOME).build();
    }

    @Override
    public boolean isAdminExisted(String adminName) {
        return false;
    }

    @Override
    public AdminDO queryAdminByName(String adminName) {
        try {
            return dao.queryAdmin(adminName);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
