package com.wang.daoimpl;

import com.wang.bean.UserMsg;
import com.wang.dao.DAO;
import com.wang.doo.UserPropertyDO;
import com.wang.util.Connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * UserPropertyDAO: usermsg表数据库操作
 * <p>
 * 访问范围: 全局
 * 获取实例: 包权限
 * 调用者: Manager
 * <p>
 * 1. 查询usermsg queryUserMsg(user_id)
 * 2. 插入usermsg insertUserMsg(User)
 * 3. 更新iconpath updateUserIcon(userid,iconpath)
 *
 * @auther ten
 */
public class UserPropertyDAO implements DAO, com.wang.dao.UserPropertyDAO {

    private UserPropertyDAO() {
    }

    static DAO newUserMsgDAO() {
        return new UserPropertyDAO();
    }

    /**
     * 查询usermsg queryUserMsg(user_id)
     *
     * @param id user_id
     * @throws SQLException         SQL异常
     * @throws NullPointerException 数据库查询为空
     */
    public UserMsg queryUserMsg(int id) throws SQLException {

        String sql = "select * from usermsg where id = " + id;

        ResultSet resultSet;

        Connection connection = Connections.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        resultSet = preparedStatement.executeQuery();

        if (resultSet == null) {
            throw new NullPointerException();
        }

        String nickname = resultSet.getString("nickname");
        String age = resultSet.getString("age");
        String sex = resultSet.getString("sex");
        String birthday = resultSet.getString("birthday");
        String email = resultSet.getString("email");
        String iconpath = resultSet.getString("iconpath");

        return new UserMsg.Builder(id).nickname(nickname).age(age).sex(sex).birthday(birthday).email(email).iconpath(iconpath).build();
    }

    /**
     * 插入usermsg insertUserMsg(User)
     *
     * @param usermsg UserMsg
     * @throws SQLException SQL异常
     */
    public void insertUserMsg(UserMsg usermsg) throws SQLException {


    }

    /**
     * 更新iconpath updateUserIcon(userid,iconpath)
     *
     * @param userid   user_id
     * @param iconpath iconpath
     * @throws SQLException SQL异常
     */
    public void updateUserIcon(int userid, String iconpath) throws SQLException {

        String sql = "update usermsg set iconpath = " + iconpath + " where id = " + userid;

        Connection connection = Connections.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.executeUpdate();
    }

    @Override
    public void insertUserProperty(UserPropertyDO userPropertyDO) throws SQLException {
        String sql = "insert into user_property(user_id,property_nickname,property_signature,property_sex," +
                "property_email,property_Location,property_birthday,property_gmt_create,property_gmt_modified) " +
                "values(?,?,?,?,?,?,?,?,?,?)";

        Connection connection = Connections.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, userPropertyDO.getUserId());
        preparedStatement.setString(2, userPropertyDO.getPropertyNickname());
        preparedStatement.setString(3, userPropertyDO.getPropertySignature());
        preparedStatement.setString(4, userPropertyDO.getPropertySex());
        preparedStatement.setString(5, userPropertyDO.getPropertyEmail());
        preparedStatement.setString(6, userPropertyDO.getPropertyLocation());
        preparedStatement.setString(6, userPropertyDO.getPropertyBirthday());
        preparedStatement.setString(6, userPropertyDO.getPropertyGmtCreate());
        preparedStatement.setString(6, userPropertyDO.getPropertyGmtModified());

        preparedStatement.executeUpdate();
    }

    @Override
    public UserPropertyDO queryUserProperty(int userId) throws SQLException {
        return null;
    }
}
