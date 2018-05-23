package com.wang.dao.jdbcimpl;

import com.wang.bean.Diary;
import com.wang.dao.dao.DiaryDAO;
import com.wang.doo.DiaryDO;
import com.wang.util.Connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * UserDAO -- jdbc实现类
 *
 * @auther ten
 */
class DiaryDAOImpl extends AbstractDAO implements DiaryDAO {
    private DiaryDAOImpl() {
    }

    static DiaryDAO newDiaryDAO() {
        return new DiaryDAOImpl();
    }

    /**
     * 查询diary queryDiary(user_id,diary_id)
     *
     * @param user_id  user_id
     * @param diary_id diary_id
     * @return Diary 数据库返回Diary对象
     * @throws SQLException         SQL异常
     * @throws NullPointerException 数据库查询为空
     */
    public Diary queryDiary(int user_id, int diary_id) throws SQLException {

        String sql = "select * from diary where user_id = " + user_id + " and diary_id = " + diary_id;

        ResultSet resultSet;

        Connection connection = Connections.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        resultSet = preparedStatement.executeQuery();

        if (resultSet == null) {
            throw new NullPointerException();
        }

        String diary_name = resultSet.getString("diary_name");
        String diary_date = resultSet.getString("diary_date");
        String diary_desc = resultSet.getString("diary_desc");

        return new Diary.Builder().diary_id(diary_id).diary_name(diary_name).diary_date(diary_date).diary_desc(diary_desc).build();
    }

    /**
     * 插入diary insertDiary(userid,diary)
     *
     * @param diary diary
     * @throws SQLException SQL异常
     */
    public void insertDiary(int userid, Diary diary) throws SQLException {

        String sql = "insert into diary values(?,?,?,?,?)";

        Connection connection = Connections.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, userid);
        preparedStatement.setInt(2, diary.getDiary_id());
        preparedStatement.setString(3, diary.getDiary_name());
        preparedStatement.setString(4, diary.getDiary_date());
        preparedStatement.setString(5, diary.getDiary_desc());

        preparedStatement.executeUpdate();
    }

    /**
     * 获取全部diaries queryDiaries(user_id)
     *
     * @param user_id user_id
     * @return List Diary 数据库返回Diary数据集
     * @throws SQLException         SQL异常
     * @throws NullPointerException 数据库查询为空
     */
    public List<Diary> queryDiaries(int user_id) throws SQLException {

        String sql = "select * from diary where id = " + user_id;

        ResultSet resultSet;

        Connection connection = Connections.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        resultSet = preparedStatement.executeQuery();

        if (resultSet == null) {
            throw new NullPointerException();
        }

        List<Diary> list = new ArrayList<>();

        //获取数据库返回数据集
        int diary_id;
        String diary_name;
        String diary_date;
        String diary_desc;
        while (resultSet.next()) {
            diary_id = resultSet.getInt("diary_id");
            diary_name = resultSet.getString("diary_name");
            diary_date = resultSet.getString("diary_date");
            diary_desc = resultSet.getString("diary_desc");
            list.add(new Diary.Builder().diary_id(diary_id).diary_name(diary_name).diary_date(diary_date)
                    .diary_desc(diary_desc).build());
        }

        return list;
    }

    @Override
    public int insertDiary(DiaryDO diaryDO) throws SQLException {
        return 0;

    }

    @Override
    public void updateDiary(DiaryDO diaryDO) throws SQLException {

    }

    @Override
    public void deleteDiary(DiaryDO diaryDO) throws SQLException {

    }

    @Override
    public DiaryDO queryDiary(String diaryName) throws SQLException {
        return null;
    }

    @Override
    public List<DiaryDO> queryDiaryList(int userId) throws SQLException {
        return null;
    }
}
