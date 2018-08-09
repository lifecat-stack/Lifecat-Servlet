//package com.wang.service.impl;
//
//import com.wang.bean.doo.AdminDO;
//import com.wang.bean.dto.AdminVO;
//import com.wang.constant.Page;
//import com.wang.dao.AdminDAO;
//import com.wang.dao.jdbcimpl.JdbcDAOFactory;
//import com.wang.service.util.Service;
//import com.wang.service.AdminLoginService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.sql.SQLException;
//
///**
// * 管理员登录
// *
// * @date 2018/5/24
// * @auther ten
// */
//class AdminLoginServiceImpl implements AdminLoginService {
//    /**
//     * 日志
//     */
//    private static final Logger logger = LoggerFactory.getLogger(AdminLoginServiceImpl.class);
//    /**
//     * @param :DAO 访问A
//     */
//    private AdminDAO dao;
//    /**
//     * DO
//     */
//    private AdminDO adminDO;
//    /**
//     * dao操作成功与否
//     */
//    private boolean success = true;
//
//    private AdminLoginServiceImpl() {
//    }
//
//    public static Service newService() {
//        return new AdminLoginServiceImpl();
//    }
//
//    @Override
//    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {
//
//        String adminName = req.getParameter("adminName");
//        String adminPassword = req.getParameter("adminPassword");
//
//        // 获取DAO实例
//        dao = (AdminDAO) new JdbcDAOFactory().getDaoByTableName("admin");
//
//        // DAO查询admin
//        adminDO = null;
//
//
//        AdminVO admin = new AdminVO(adminDO.getAdminId(), adminDO.getAdminName(), adminDO.getAdminLevel()).build();
//        req.getSession().setAttribute("admin", admin);
//        return new ServiceResult.Builder(true).page(Page.PAGE_USERHOME).build();
//    }
//
//    private String queryAdmin(String adminName) {
//
//        try {
//            adminDO = dao.queryAdmin(adminName);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        printError();
//    }
//
//    private void printError() {
//        if (!success) {
//            logger.warn("数据库查询异常");
//            success = false;
//
//        }
//        if (adminDO == null) {
//            logger.warn("数据库无此管理员");
//            success = false;
//
//        }
//        if (!ada.equals(adminDO.getAdminPassword())) {
//            logger.warn("管理员密码错误");
//            success = false;
//
//        }
//    }
//
//    private void result() {
//
//    }
//
//    @Override
//    public boolean isAdminExisted(String adminName) {
//        return false;
//    }
//
//    @Override
//    public AdminDO queryAdminByName(String adminName) {
//        return null;
//    }
//}
