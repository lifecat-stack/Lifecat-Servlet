package com.ten.lifecat.servlet.dao.jdbcimpl;

import com.ten.lifecat.servlet.dao.BaseDaoImpl;
import com.ten.lifecat.servlet.dao.UserPropertyDao;
import com.ten.lifecat.servlet.entity.UserProperty;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * UserPropertyDAO -- jdbc实现类
 *
 * @auther ten
 */
public class UserPropertyDAOImpl extends BaseDaoImpl implements UserPropertyDao {
    public UserPropertyDAOImpl() {
    }

    @Override
    public void insertUserProperty(UserProperty userProperty) throws SQLException {
        String sql = "insert into " +
                "user_property(user_id," +
                "nickname," +
                "signature," +
                "sex," +
                "email," +
                "location," +
                "birthday," +
                "create_time," +
                "update_time)" +
                " values(?,?,?,?,?,?,?,?,?)";
        Object[] args = {
                userProperty.getUserId(),
                userProperty.getNickname(),
                userProperty.getSignature(),
                userProperty.getSex(),
                userProperty.getEmail(),
                userProperty.getLocation(),
                userProperty.getBirthday(),
                userProperty.getCreateTime(),
                userProperty.getUpdateTime()
        };
        insert(sql, args);
    }

    @Override
    public UserProperty queryUserProperty(Integer userId) throws SQLException {
        String sql = "select " +
                "nickname," +
                "signature," +
                "sex," +
                "email," +
                "location," +
                "birthday," +
                "create_time," +
                "update_time" +
                " from user_property where user_id = '" + userId + "'";

        ResultSet resultSet = query(sql);
        resultSet.next();

        UserProperty userProperty = new UserProperty();
        userProperty.setUserId(userId);
        userProperty.setNickname(resultSet.getString("nickname"));
        userProperty.setSignature(resultSet.getString("signature"));
        userProperty.setSex(resultSet.getString("sex"));
        userProperty.setEmail(resultSet.getString("email"));
        userProperty.setLocation(resultSet.getString("location"));
        userProperty.setBirthday(resultSet.getString("birthday"));
        userProperty.setCreateTime(resultSet.getString("create_time"));
        userProperty.setUpdateTime(resultSet.getString("update_time"));
        return userProperty;
    }
}
