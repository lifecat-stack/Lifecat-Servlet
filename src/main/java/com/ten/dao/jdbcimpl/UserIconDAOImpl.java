package com.ten.dao.jdbcimpl;

import com.ten.dao.BaseDAO;
import com.ten.dao.UserIconDAO;
import com.ten.bean.entity.UserIconDO;

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
    public void insertUserIcon(UserIconDO userIconDO) throws SQLException {
        String sql = "insert into user_icon(user_id,icon_path,icon_gmt_create,icon_gmt_modified) " +
                " VALUES( ?,?,?,?)";
        Object[] args = {userIconDO.getUserId(), userIconDO.getIconPath(), userIconDO.getIconGmtCreate(), userIconDO.getIconGmtModified()};
        insert(sql, args);
    }

    @Override
    public void updateUserIcon(UserIconDO userIconDO) throws SQLException {
        String sql = "update user_icon set icon_path = '"
                + userIconDO.getIconPath()
                + "' ,icon_gmt_modified = '"
                + userIconDO.getIconGmtModified()
                + "'  where user_id = '" + userIconDO.getUserId() + "'";
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
