package com.ten.lifecat.servlet.service.impl;

import com.ten.lifecat.servlet.dao.JdbcDAOFactory;
import com.ten.service.DiaryAllDeleteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * TODO 删除所有日记
 *
 * @author wshten
 * @date 2018/11/9
 */
public class DiaryAllDeleteServiceImpl implements DiaryAllDeleteService {
    private static final Logger logger = LoggerFactory.getLogger(DiaryAllDeleteServiceImpl.class);
    private static final DiaryDAO DAO = (DiaryDAO) JdbcDAOFactory.getDaoByTableName("diary");

    public DiaryAllDeleteServiceImpl() {
    }

    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {
        logger.error("功能未开放");
        return null;
    }

    @Override
    public void deleteAllDiary(int userId) {
    }
}
