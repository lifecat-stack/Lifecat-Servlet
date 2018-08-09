package com.ten.service.impl;

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

    public DiaryAllDeleteServiceImpl() {
    }

    @Override
    public void deleteAllDiary() {

    }

    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {

        Integer userId = 1;

        // 获取DAO实例
        DAOFactory factory = new JdbcDAOFactory();
        DiaryDAO dao = (DiaryDAO) factory.getDaoByTableName("diary");

        boolean success = false;
        try {
            dao.deleteAllDiary(userId);
            success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (!success) {
            return new ServiceResult.Builder(false)
                    .errormsg("日记删除失败").page(Page.PAGE_USERHOME).build();
        }

        return new ServiceResult.Builder(true).page(Page.PAGE_USERHOME).build();
    }
}
