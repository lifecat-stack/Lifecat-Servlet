package com.wang.service.serviceimpl;

import com.wang.constant.HOST;
import com.wang.dao.dao.AdminDAO;
import com.wang.dao.dao.DAOFactory;
import com.wang.dao.jdbcimpl.JdbcDAOFactory;
import com.wang.bean.doo.AdminDO;
import com.wang.bean.dto.AdminDTO;
import com.wang.service.service.Service;
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
public class AdminLogin implements Service {
 private Logger logger = LoggerFactory.getLogger(AdminLogin.class);

    private AdminLogin() {
    }

    static Service newService() {
        return new AdminLogin();
    }
    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {
        String adminName = req.getParameter("adminName");
        String adminPassword = req.getParameter("adminPassword");

        // 获取DAO实例
        DAOFactory factory = new JdbcDAOFactory();
        AdminDAO dao = factory.getAdminDAO();

        // DAO查询admin
        AdminDO adminDO = null;
        boolean success = false;
        try {
            adminDO = dao.queryAdmin(adminName);
            success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (!success) {
            return new ServiceResult.Builder(true)
                    .errormsg("数据库查询异常").page(req.getRequestURI()).build();
        }

        if (adminDO == null) {
            return new ServiceResult.Builder(true)
                    .errormsg("数据库无此管理员").page(req.getRequestURI()).build();
        }

        if (!adminPassword.equals(adminDO.getAdminPassword())) {
            return new ServiceResult.Builder(true)
                    .errormsg("管理员密码错误").page(req.getRequestURI()).build();
        }

        AdminDTO admin = new AdminDTO.Builder(adminDO.getAdminId(), adminDO.getAdminName(), adminDO.getAdminLevel()).build();
        req.getSession().setAttribute("admin", admin);
        return new ServiceResult.Builder(true).page(HOST.PAGE_USERHOME).build();
    }
}
