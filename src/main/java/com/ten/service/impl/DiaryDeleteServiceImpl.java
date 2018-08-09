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
 *
 * 失败 Page.PAGE_DIARYSHOW
 * 成功 Page.PAGE_DIARYSHOW
 *
 * @date 2018/5/24
 * @auther ten
 */
public class DiaryDeleteServiceImpl implements DiaryDeleteService {
    private Logger logger = LoggerFactory.getLogger(DiaryDeleteServiceImpl.class);

    public DiaryDeleteServiceImpl() {
    }

    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {

        String diaryId = req.getParameter("diaryId");
        logger.debug("diary id is {}",diaryId);

        // 获取DAO实例
        DAOFactory factory = new JdbcDAOFactory();
        DiaryDAO dao = (DiaryDAO) factory.getDaoByTableName("diary");

        boolean success = false;
        try {
            dao.deleteDiary(Integer.valueOf(diaryId));
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

    @Override
    public void deleteDiary() {

    }
}
