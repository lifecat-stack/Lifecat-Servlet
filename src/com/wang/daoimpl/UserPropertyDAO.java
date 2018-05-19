package com.wang.daoimpl;

import com.wang.bean.UserMsg;
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
public class UserPropertyDAO implements DAO {

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

        String sql = "insert into usermsg(user_id,nickname,age,sex,birthday,email) values(?,?,?,?,?,?)";

        Connection connection = Connections.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, usermsg.getUser_id());
        preparedStatement.setString(2, usermsg.getNickname());
        preparedStatement.setString(3, usermsg.getAge());
        preparedStatement.setString(4, usermsg.getSex());
        preparedStatement.setString(5, usermsg.getBirthday());
        preparedStatement.setString(6, usermsg.getEmail());

        preparedStatement.executeUpdate();
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
}
