package com.wang.daoimpl;

import com.wang.dao.AdminDAO;
import com.wang.doo.AdminDO;
import com.wang.util.Connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAOImpl implements DAO, AdminDAO {
    private AdminDAOImpl() {
    }

    static DAO newAdminDAO() {
        return new AdminDAOImpl();
    }

    @Override
    public int insertAdmin(AdminDO adminDO) throws SQLException {
        String sql =
                "insert into admin(admin_name,admin_password" +
                        ",admin_levle,admin_gmt_create,admin_gmt_modified) " +
                        "values(?,?,?,?,?)";

        Connection connection = Connections.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, adminDO.getAdmin_name());
        preparedStatement.setString(2, adminDO.getAdmin_password());
        preparedStatement.setString(3, adminDO.getAdmin_level());
        preparedStatement.setString(4, adminDO.getAdmin_gmt_create());
        preparedStatement.setString(5, adminDO.getAdmin_gmt_modified());

        preparedStatement.executeUpdate();

        // 获取自增长主键值
        ResultSet rs = preparedStatement.getGeneratedKeys();
        rs.next();

        return rs.getInt(1);
    }

    @Override
    public AdminDO queryAdmin(String adminName) throws SQLException {
        String sql = "select (admin_id,admin_password,admin_level) from admin where admin_name = " + adminName;

        ResultSet resultSet;

        Connection connection = Connections.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        resultSet = preparedStatement.executeQuery();

        if (resultSet == null) {
            throw new NullPointerException();
        }

        int adminId = resultSet.getInt("admin_id");
        String adminPassword = resultSet.getString("admin_password");
        String adminLevel = resultSet.getString("admin_level");

        AdminDO adminDO = new AdminDO();
        adminDO.setAdmin_id(adminId);
        adminDO.setAdmin_name(adminName);
        adminDO.setAdmin_password(adminPassword);
        adminDO.setAdmin_level(adminLevel);

        return adminDO;
    }

    @Override
    public boolean isAdminExisted(String adminName) throws SQLException {
        String sql = "select count(*) from admin where admin_name = " + adminName;

        ResultSet resultSet;

        Connection connection = Connections.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        resultSet = preparedStatement.executeQuery();

        if (resultSet == null) {
            return false;
        }

        return resultSet.getInt(1) > 0;
    }


    // TODO 修改admin信息
    public void updateAdmin() {

    }
}
