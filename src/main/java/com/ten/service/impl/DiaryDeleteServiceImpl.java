package com.ten.service.impl;

import com.ten.constant.Page;
import com.ten.dao.DiaryDAO;
import com.ten.dao.JdbcDAOFactory;
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
    private static final Logger logger = LoggerFactory.getLogger(DiaryDeleteServiceImpl.class);
    private static final DiaryDAO DAO = (DiaryDAO) JdbcDAOFactory.getDaoByTableName("diary");

    public DiaryDeleteServiceImpl() {
    }

    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("diaryId");
        if ("".equals(id)) {
            return new ServiceResult.Builder(false)
                    .page(Page.PAGE_USERHOME)
                    .errormsg("日记ID不能为空")
                    .build();
        }

        int diaryId = Integer.parseInt(id);

        deleteDiary(diaryId);

        return new ServiceResult.Builder(true)
                .page(Page.PAGE_USERHOME)
                .build();
    }

    @Override
    public Integer deleteDiary(int diaryId) {
        try {
            return DAO.deleteDiary(diaryId);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
