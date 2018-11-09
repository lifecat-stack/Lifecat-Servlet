package com.ten.dao.jdbcimpl;

import com.ten.dao.AdminDAO;
import com.ten.bean.entity.Admin;
import com.ten.dao.BaseDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * UserDAO -- jdbc实现类
 *
 * @auther ten
 */
public class AdminDAOImpl extends BaseDAO implements AdminDAO {
    public AdminDAOImpl() {
    }

    @Override
    public void insertAdmin(Admin admin) throws SQLException {
        String sql = "insert into admin(admin_name,admin_password" +
                ",admin_level,admin_gmt_create,admin_gmt_modified) " +
                "values(?,?,?,?,?)";
        Object[] args = {admin.getAdminName(), admin.getAdminPassword(), admin.getAdminLevel(),
                admin.getAdminGmtCreate(), admin.getAdminGmtModified()};
        insert(sql, args);
    }

    @Override
    public Admin queryAdmin(String adminName) throws SQLException {
        String sql = "select admin_id,admin_name,admin_password,admin_level from admin where admin_name = '" + adminName + "'";
        ResultSet resultSet = query(sql);
        resultSet.next();
        Admin admin = new Admin();
        admin.setAdminId(resultSet.getInt("admin_id"));
        admin.setAdminName(adminName);
        admin.setAdminPassword(resultSet.getString("admin_password"));
        admin.setAdminLevel(resultSet.getString("admin_level"));
        return admin;
    }

    @Override
    public boolean isAdminExisted(String adminName) throws SQLException {
        String sql = "select count(admin_id) from admin where admin_name = '" + adminName + "'";

        ResultSet resultSet = query(sql);
        resultSet.next();
        return resultSet.getInt(1) > 0;
    }
}
