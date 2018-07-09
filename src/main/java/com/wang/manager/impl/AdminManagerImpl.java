//package com.wang.manager.impl;
//
//import com.wang.bean.doo.AdminDO;
//import com.wang.bean.dto.AdminDTO;
//import com.wang.dao.AdminDAO;
//import com.wang.dao.DAOFactory;
//import com.wang.dao.jdbcimpl.JdbcDAOFactory;
//import com.wang.manager.AdminManager;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.sql.SQLException;
//
///**
// * Admin管理器
// *
// * @date 2018/6/29
// * @auther ten
// */
//public class AdminManagerImpl implements AdminManager {
//
//    private Logger logger;
//
//    private DAOFactory factory;
//
//    private AdminDAO adminDAO;
//
//    /**
//     * 构造函数
//     */
//    public AdminManagerImpl() {
//        logger = LoggerFactory.getLogger(AdminManagerImpl.class);
//
//        factory = new JdbcDAOFactory();
//
//        adminDAO = (AdminDAO) factory.getDaoByTableName("admin");
//    }
//
//    /**
//     * 管理员登录
//     *
//     * @param adminDO Form提交的信息
//     * @return AdminDTO Admin数据传输对象
//     */
//    @Override
//    public AdminDTO adminLogin(AdminDO adminDO) {
//
//        String adminName = adminDO.getAdminName();
//
//        boolean existed = isAdminExisted(adminName);
//
//        // 账户不存在
//        if (!existed) {
//            return null;
//        }
//
//        AdminDO admin = queryAdmin(adminName);
//
//        // 查询出错
//        if (admin == null) {
//            return null;
//        }
//
//        // DTO
//        return new AdminDTO.Builder(
//                admin.getAdminId(),
//                admin.getAdminName(),
//                admin.getAdminLevel()
//        ).build();
//    }
//
//
//    /**
//     * 判断账户是否存在
//     *
//     * @return true/false ? 账户存在 : 账户不存在
//     */
//    private boolean isAdminExisted(String adminName) {
//        try {
//            return adminDAO.isAdminExisted(adminName);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            logger.warn("\"query admin existed\" is error");
//            return true;
//        }
//    }
//
//    /**
//     * 获取admin信息
//     *
//     * @return AdminDO 数据表数据DO
//     */
//    private AdminDO queryAdmin(String adminName) {
//        try {
//            return adminDAO.queryAdmin(adminName);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            logger.warn("\"query admin\" is error");
//            return null;
//        }
//    }
//
//    @Override
//    public AdminDTO adminRegister(AdminDO adminDO) {
//        return null;
//    }
//}
