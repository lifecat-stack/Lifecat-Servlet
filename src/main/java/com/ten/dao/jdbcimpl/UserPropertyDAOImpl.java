package com.ten.dao.jdbcimpl;

import com.ten.dao.BaseDAO;
import com.ten.dao.UserPropertyDAO;
import com.ten.bean.entity.UserPropertyDO;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * UserPropertyDAO -- jdbc实现类
 *
 * @auther ten
 */
public class UserPropertyDAOImpl extends BaseDAO implements UserPropertyDAO {
    public  UserPropertyDAOImpl() {
    }

    @Override
    public void insertUserProperty(UserPropertyDO userPropertyDO) throws SQLException {
        String sql = "insert into " +
                "user_property(user_id," +
                "property_nickname," +
                "property_signature," +
                "property_sex," +
                "property_email," +
                "property_location," +
                "property_birthday," +
                "property_gmt_create," +
                "property_gmt_modified)" +
                " values(?,?,?,?,?,?,?,?,?)";
        Object[] args = {
                userPropertyDO.getUserId(),
                userPropertyDO.getPropertyNickname(),
                userPropertyDO.getPropertySignature(),
                userPropertyDO.getPropertySex(),
                userPropertyDO.getPropertyEmail(),
                userPropertyDO.getPropertyLocation(),
                userPropertyDO.getPropertyBirthday(),
                userPropertyDO.getPropertyGmtCreate(),
                userPropertyDO.getPropertyGmtModified()
        };
        insert(sql, args);
    }

    @Override
    public UserPropertyDO queryUserProperty(Integer userId) throws SQLException {
        String sql = "select " +
                "property_nickname," +
                "property_signature," +
                "property_sex," +
                "property_email," +
                "property_location," +
                "property_birthday," +
                "property_gmt_create," +
                "property_gmt_modified" +
                " from user_property where user_id = '" + userId + "'";

        ResultSet resultSet = query(sql);
        resultSet.next();

        UserPropertyDO userPropertyDO = new UserPropertyDO();
        userPropertyDO.setUserId(userId);
        userPropertyDO.setPropertyNickname(resultSet.getString("property_nickname"));
        userPropertyDO.setPropertySignature(resultSet.getString("property_signature"));
        userPropertyDO.setPropertySex(resultSet.getString("property_sex"));
        userPropertyDO.setPropertyEmail(resultSet.getString("property_email"));
        userPropertyDO.setPropertyLocation(resultSet.getString("property_location"));
        userPropertyDO.setPropertyBirthday(resultSet.getString("property_birthday"));
        userPropertyDO.setPropertyGmtCreate(resultSet.getString("property_gmt_create"));
        userPropertyDO.setPropertyGmtModified(resultSet.getString("property_gmt_modified"));
        return userPropertyDO;
    }
}
