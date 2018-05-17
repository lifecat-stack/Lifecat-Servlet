package com.wang.dao;

import com.wang.doo.AdminDO;
import com.wang.util.Connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminDAO implements DAO {
    private AdminDAO() {
    }

    static DAO newAdminDAO() {
        return new AdminDAO();
    }

    //插入admin对象, 返回自增长主键admin_id
    public void insertAdmin(AdminDO adminDO) throws SQLException {
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
    }

    //通过admin_name(uk)获取数据库admin对象
    public void queryAdmin(String admin_name) {

    }

    public void updateAdmin() {

    }

    public void
}
