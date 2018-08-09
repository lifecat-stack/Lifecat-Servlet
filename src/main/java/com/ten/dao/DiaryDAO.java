package com.ten.dao;

import com.ten.bean.entity.DiaryDO;

import java.sql.SQLException;
import java.util.List;

/**
 * dao - diary
 *
 * @auther ten
 */
public interface DiaryDAO {
    /**
     * 日记上传 :
     * 插入DiaryDO到diary表
     * 返回自增长主键diary_id
     *
     * @param diaryDO diaryDO
     * @return diary_id
     * @throws SQLException e
     */
    int insertDiary(DiaryDO diaryDO) throws SQLException;

    /**
     * 日记更新 :
     * 根据diary_id进行内容的更新
     *
     * @param diaryDO diaryDO
     * @throws SQLException e
     */
    void updateDiary(DiaryDO diaryDO) throws SQLException;

    /**
     * 日记删除 :
     * 根据diary_id进行删除
     *
     * @param diaryId diaryId
     * @throws SQLException e
     */
    void deleteDiary(Integer diaryId) throws SQLException;

    void deleteAllDiary(Integer userId) throws SQLException;

    /**
     * 日记单个查询 :
     * 通过diary_name(uk)进行查询
     * 获取数据库diary信息
     * diary信息封装在DiaryDO中返回
     *
     * @param diaryName 图片名
     * @return DiaryDO DiaryDO
     * @throws SQLException         e
     * @throws NullPointerException 记录不存在
     */
    DiaryDO queryDiary(String diaryName) throws SQLException;

    /**
     * 日记全部查询 :
     * 通过user_id进行查询
     * 获取数据库diarylist信息
     * diarylist信息封装在{@literal List<DiaryDO>}中返回
     *
     * @param userId 用户ID
     * @return {@literal List<DiaryDO> List}
     * @throws SQLException         e
     * @throws NullPointerException 记录不存在
     */
    List<DiaryDO> queryDiaryList(Integer userId) throws SQLException;
}
