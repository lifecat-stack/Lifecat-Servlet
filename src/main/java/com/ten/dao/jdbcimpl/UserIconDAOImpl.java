package com.ten.dao.jdbcimpl;

import com.ten.dao.BaseDAO;
import com.ten.dao.UserIconDAO;
import com.ten.bean.entity.UserIcon;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * UserIconDAO -- jdbc实现类
 *
 * @auther ten
 */
public class UserIconDAOImpl extends BaseDAO implements UserIconDAO {
    public  UserIconDAOImpl() {
    }


    @Override
    public void insertUserIcon(UserIcon userIcon) throws SQLException {
        String sql = "insert into user_icon(user_id,icon_path,icon_gmt_create,icon_gmt_modified) " +
                " VALUES( ?,?,?,?)";
        Object[] args = {userIcon.getUserId(), userIcon.getIconPath(), userIcon.getIconGmtCreate(), userIcon.getIconGmtModified()};
        insert(sql, args);
    }

    @Override
    public void updateUserIcon(UserIcon userIcon) throws SQLException {
        String sql = "update user_icon set icon_path = '"
                + userIcon.getIconPath()
                + "' ,icon_gmt_modified = '"
                + userIcon.getIconGmtModified()
                + "'  where user_id = '" + userIcon.getUserId() + "'";
        update(sql);
    }

    @Override
    public String queryUserIcon(Integer userId) throws SQLException {
        String sql = "select icon_path from user_icon where user_id = '" + userId + "'";
        ResultSet rs = query(sql);
        rs.next();
        return rs.getString("icon_path");
    }
}
