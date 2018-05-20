package com.wang.service;

import com.wang.bean.Diary;
import com.wang.bean.User;
import com.wang.manager.ManagerFactory;
import com.wang.manager.DiaryManager;
import com.wang.util.HOST;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * DiaryListQuery: 从数据库获取diary数据
 * <p>
 * 访问范围: protected
 * 调用者: ActionServlet
 * Return: ServiceResult Object
 * Use try-catch to handle Exception
 * <li>
 * queryDiaries() by user_id from user
 * </li>
 * <li>
 * {@literal set List<Diary> to Session}
 * </li>
 *
 * @auther ten
 */
public class DiaryListQuery implements Service {

    private Logger logger;

    private DiaryListQuery() {
        logger = Logger.getLogger("DiaryListQuery");
    }

    static Service getModel() {
        return new DiaryListQuery();
    }

    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {

        User user = (User) req.getSession().getAttribute("user");

        DiaryManager daoModel = (DiaryManager) ManagerFactory.getManagerByName(user.getId(), "DiaryManager");

        List<Diary> diaries = null;

        boolean isSuccess;
        String errormsg = null;

        //获取diaries
        try {
            diaries = daoModel.queryDiaries(user.getId());
            isSuccess = true;
        } catch (SQLException e) {
            e.printStackTrace();
            isSuccess = false;
            errormsg = "SQLException";
        } catch (NullPointerException e) {
            e.printStackTrace();
            isSuccess = false;
            errormsg = "数据库查询为空";
        }

        if (isSuccess) {
            req.getSession().setAttribute("diarys", diaries);
            return new ServiceResult.Builder(false).page(HOST.PAGE_USERHOME).build();
        }

        diaries = new ArrayList<>();
        req.getSession().setAttribute("diarys", diaries);
        return new ServiceResult.Builder(true).errormsg(errormsg).page(HOST.PAGE_USERHOME).build();
    }
}
