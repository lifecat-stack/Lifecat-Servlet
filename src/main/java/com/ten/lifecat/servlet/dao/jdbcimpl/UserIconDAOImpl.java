package com.ten.lifecat.servlet.dao.jdbcimpl;

import com.ten.lifecat.servlet.dao.BaseDaoImpl;
import com.ten.lifecat.servlet.entity.UserIcon;
import com.ten.lifecat.servlet.dao.BaseDaoImpl;
import com.ten.lifecat.servlet.entity.UserIcon;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * UserIconDAO -- jdbc实现类
 *
 * @auther ten
 */
public class UserIconDAOImpl extends BaseDaoImpl implements UserIconDAO {
    public UserIconDAOImpl() {
    }


    @Override
    public void insertUserIcon(UserIcon userIcon) throws SQLException {
        String sql = "insert into user_icon(user_id,icon_path,create_time,update_time) " +
                " VALUES( ?,?,?,?)";
        Object[] args = {userIcon.getUserId(), userIcon.getIconPath(), userIcon.getCreateTime(), userIcon.getUpdateTime()};
        insert(sql, args);
    }

    @Override
    public void updateUserIcon(UserIcon userIcon) throws SQLException {
        String sql = "update user_icon set icon_path = '"
                + userIcon.getIconPath()
                + "' ,update_time = '"
                + userIcon.getUpdateTime()
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
