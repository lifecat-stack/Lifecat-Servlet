package com.wang.model;

import com.wang.bean.Diary;
import com.wang.bean.User;
import com.wang.dao.DiaryDAO;
import com.wang.db.MyDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @name UpDiaryModel
 * @description 上传日记，对应表单UpDiary，对应页面userhome.jsp
 * @auther tem
 */
public class UpDiaryModel extends MyModel {

    private DiaryDAO dao;
    private Diary bean;

    /* 初始化 */
    public UpDiaryModel() {
        dao = new DiaryDAO();
        bean = new Diary();
        errorMsg = new ErrorMsg();
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        /* 获取表单的提交数据 */
        String diaryname = (String) req.getParameter("diaryname");
        String diarydescription = (String) req.getParameter("diarydescription");

        String diarydate=MyDate.GetNowDate();
        String diarypath= "http://"+ip+":8080/lifecatweb/diary";

        /* 获取session中的user对象 */
        User user = (User) req.getSession().getAttribute("User");
        /* 获取用户id */
        int userid=0;
        if (user!=null) {
            userid = user.getId();
        }

        bean.setId(userid);
        bean.setName(diaryname);
        bean.setDescription(diarydescription);
        bean.setDate(diarydate);
        bean.setPath(diarypath);

         String page = host_userhome;

        boolean success = dao.uploadDiary(bean);

        /* 若设置成功 */
        if (success) {
            System.out.println("上传日记成功");
        }
        /* 设置失败 */
        else {
            System.out.println("上传日记失败");
        }
        try {
            resp.sendRedirect(page);
        } catch (IOException e) {
            System.out.println("上传日记后跳转失败");
            e.printStackTrace();
        }
    }
}
