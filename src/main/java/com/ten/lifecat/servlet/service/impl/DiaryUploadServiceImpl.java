package com.ten.lifecat.servlet.service.impl;

import com.ten.lifecat.servlet.entity.Diary;
import com.ten.bean.vo.UserVO;
import com.ten.constant.Page;
import com.ten.lifecat.servlet.dao.JdbcDAOFactory;
import com.ten.lifecat.servlet.constant.Page;
import com.ten.service.DiaryUploadService;
import com.ten.lifecat.servlet.util.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * 日记上传
 * <p>
 * 失败 Page.PAGE_UPDIARY
 * 成功 Page.PAGE_USERHOME
 *
 * @date 2018/5/24
 * @auther ten
 */
public class DiaryUploadServiceImpl implements DiaryUploadService {

    private Logger logger = LoggerFactory.getLogger(DiaryUploadServiceImpl.class);

    private DiaryDAO dao;

    public DiaryUploadServiceImpl() {
        dao = (DiaryDAO) JdbcDAOFactory.getDaoByTableName("diary");
    }

    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {
        UserVO userDTO = (UserVO) req.getSession().getAttribute("user");
        Integer userId = userDTO.getUserId();

        String diaryName = req.getParameter("diaryName");
        String diaryText = req.getParameter("diaryText");
        String dateTime = DateTimeUtil.getInstance().getCurrentTime();

        Diary diary = new Diary();
        diary.setUserId(userId);
        diary.setDiaryName(diaryName);
        diary.setdiaryText(diaryText);
        diary.setIsDeleted(0);
        diary.setdiaryGmtCreate(dateTime);
        diary.setdiaryGmtModified(dateTime);

        return new ServiceResult.Builder(true).page(Page.PAGE_USERHOME).build();
    }

    @Override
    public void uploadDiary(Diary diary) {
        try {
            dao.insertDiary(diary);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
