package com.ten.service.impl;

import com.ten.bean.vo.UserVO;
import com.ten.constant.Page;
import com.ten.dao.DAOFactory;
import com.ten.dao.DiaryDAO;
import com.ten.dao.jdbcimpl.JdbcDAOFactory;
import com.ten.service.DiaryAllDeleteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class DiaryAllDeleteServiceImpl implements DiaryAllDeleteService {

    private Logger logger = LoggerFactory.getLogger(DiaryAllDeleteServiceImpl.class);

    private DiaryDAO dao;

    public DiaryAllDeleteServiceImpl() {
        DAOFactory factory = new JdbcDAOFactory();
        dao = (DiaryDAO) factory.getDaoByTableName("diary");
    }

    @Override
    public void deleteAllDiary(int userId) {
        try {
            dao.deleteAllDiary(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {

        UserVO user = (UserVO) req.getSession().getAttribute("user");
        int userId = user.getUserId();

        deleteAllDiary(userId);

        return new ServiceResult.Builder(true).page(Page.PAGE_USERHOME).build();
    }
}
