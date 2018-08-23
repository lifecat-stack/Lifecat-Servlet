package com.ten.service.impl;

import com.ten.bean.entity.DiaryDO;
import com.ten.constant.Page;
import com.ten.dao.DAOFactory;
import com.ten.dao.DiaryDAO;
import com.ten.dao.jdbcimpl.JdbcDAOFactory;
import com.ten.service.DiaryUpdateService;
import com.ten.util.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * 日记内容更新
 *
 * @date 2018/5/24
 * @auther ten
 */
public class DiaryUpdateServiceImpl implements DiaryUpdateService {
    private Logger logger = LoggerFactory.getLogger(DiaryUpdateServiceImpl.class);

    private DiaryDAO dao;

    public DiaryUpdateServiceImpl() {
        DAOFactory factory = new JdbcDAOFactory();
        dao = (DiaryDAO) factory.getDaoByTableName("diary");
    }

    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {

        String diaryId = req.getParameter("diaryId");
        String diaryName = req.getParameter("diaryName");
        String diaryText = req.getParameter("diaryText");
        String dateTime = DateTimeUtil.getInstance().getCurrentTime();

        logger.debug("diary id:{} name:{} text:{} date:{}", diaryId, diaryName, diaryText, dateTime);
        assert diaryId != null;

        DiaryDO diaryDO = new DiaryDO();
        diaryDO.setDiaryId(Integer.valueOf(diaryId));
        diaryDO.setDiaryName(diaryName);
        diaryDO.setdiaryText(diaryText);
        diaryDO.setdiaryGmtModified(dateTime);

        updateDiary(diaryDO);
        return new ServiceResult.Builder(true).page(Page.PAGE_USERHOME).build();
    }

    @Override
    public void updateDiary(DiaryDO diaryDO) {
        try {
            dao.updateDiary(diaryDO);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
