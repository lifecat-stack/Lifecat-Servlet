package com.ten.dao.jdbcimpl;

import com.ten.bean.entity.UserProperty;
import com.ten.dao.BaseDAO;
import com.ten.dao.UserPropertyDAO;

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
    public void insertUserProperty(UserProperty userProperty) throws SQLException {
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
                userProperty.getUserId(),
                userProperty.getPropertyNickname(),
                userProperty.getPropertySignature(),
                userProperty.getPropertySex(),
                userProperty.getPropertyEmail(),
                userProperty.getPropertyLocation(),
                userProperty.getPropertyBirthday(),
                userProperty.getPropertyGmtCreate(),
                userProperty.getPropertyGmtModified()
        };
        insert(sql, args);
    }

    @Override
    public UserProperty queryUserProperty(Integer userId) throws SQLException {
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

        UserProperty userProperty = new UserProperty();
        userProperty.setUserId(userId);
        userProperty.setPropertyNickname(resultSet.getString("property_nickname"));
        userProperty.setPropertySignature(resultSet.getString("property_signature"));
        userProperty.setPropertySex(resultSet.getString("property_sex"));
        userProperty.setPropertyEmail(resultSet.getString("property_email"));
        userProperty.setPropertyLocation(resultSet.getString("property_location"));
        userProperty.setPropertyBirthday(resultSet.getString("property_birthday"));
        userProperty.setPropertyGmtCreate(resultSet.getString("property_gmt_create"));
        userProperty.setPropertyGmtModified(resultSet.getString("property_gmt_modified"));
        return userProperty;
    }
}
