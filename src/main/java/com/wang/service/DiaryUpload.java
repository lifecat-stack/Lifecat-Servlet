package com.wang.service;

import com.wang.bean.Diary;
import com.wang.bean.User;
import com.wang.manager.ManagerFactory;
import com.wang.manager.DiaryManager;
import com.wang.constant.HOST;
import com.wang.util.MyDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * DiaryUpload: 上传diary
 * <p>
 * 访问范围: 包
 * 调用者: Servlet
 * 异常检测: try-catch异常处理层
 * <p>
 * 1. 获取diary
 * 2. insertDiary(diary) to diary
 *
 * @auther ten
 */
class DiaryUpload implements Service {

    private Logger logger;

    private DiaryUpload() {
        logger = Logger.getLogger("DiaryUpload");
    }

    static Service getModel() {
        return new DiaryUpload();
    }

    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {

        String diary_name = req.getParameter("diary_name");
        String diary_desc = req.getParameter("diary_desc");

        String diary_date = MyDate.getInstance().getCurrentTime();

        User user = (User) req.getSession().getAttribute("user");

        Diary diary = new Diary.Builder().diary_name(diary_name).diary_desc(diary_desc).diary_date(diary_date).build();

        logger.info(diary.toString());

        DiaryManager daoModel = (DiaryManager) ManagerFactory.getManagerByName(user.getId(), "DiaryManager");

        //插入diary
        try {
            daoModel.insertDiary(diary);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return new ServiceResult.Builder(true).errormsg("diary argument has null").page(HOST.PAGE_USERHOME).build();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ServiceResult.Builder(true).errormsg("SQLException").page(HOST.PAGE_USERHOME).build();
        }

        return new ServiceResult.Builder(false).page(HOST.PAGE_USERHOME).build();
    }
}
