package com.ten.service.impl;

import com.ten.constant.Page;
import com.ten.dao.DAOFactory;
import com.ten.dao.DiaryDAO;
import com.ten.dao.jdbcimpl.JdbcDAOFactory;
import com.ten.service.DiaryDeleteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * 日记删除
 * <p>
 * 失败 Page.PAGE_DIARYSHOW
 * 成功 Page.PAGE_DIARYSHOW
 *
 * @date 2018/5/24
 * @auther ten
 */
public class DiaryDeleteServiceImpl implements DiaryDeleteService {

    private Logger logger = LoggerFactory.getLogger(DiaryDeleteServiceImpl.class);

    private DiaryDAO dao;

    public DiaryDeleteServiceImpl() {
        DAOFactory factory = new JdbcDAOFactory();
        dao = (DiaryDAO) factory.getDaoByTableName("diary");
    }

    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {
        int diaryId = Integer.parseInt(req.getParameter("diaryId"));

        deleteDiary(diaryId);

        return new ServiceResult.Builder(true).page(Page.PAGE_USERHOME).build();
    }

    @Override
    public void deleteDiary(int diaryId) {
        try {
            dao.deleteDiary(diaryId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
