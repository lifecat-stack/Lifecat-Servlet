package com.wang.service;

import com.wang.bean.Diary;
import com.wang.bean.User;
import com.wang.daomanager.DAOModelFactory;
import com.wang.daomanager.DiaryDAOModel;
import com.wang.util.HOST;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * GetDiariesModel: 从数据库获取diary数据
 * <p>
 * 访问范围: protected
 * 调用者: ActionServlet
 * Return: ModelResult Object
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
public class GetDiariesModel implements ServiceModel {

    private Logger logger;

    private GetDiariesModel() {
        logger = Logger.getLogger("GetDiariesModel");
    }

    static ServiceModel getModel() {
        return new GetDiariesModel();
    }

    @Override
    public ModelResult execute(HttpServletRequest req, HttpServletResponse resp) {

        User user = (User) req.getSession().getAttribute("user");

        DiaryDAOModel daoModel = (DiaryDAOModel) DAOModelFactory.getDAOModelByName(user.getId(), "DiaryDAOModel");

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
            return new ModelResult.Builder(false).page(HOST.PAGE_USERHOME).build();
        }

        diaries = new ArrayList<>();
        req.getSession().setAttribute("diarys", diaries);
        return new ModelResult.Builder(true).errormsg(errormsg).page(HOST.PAGE_USERHOME).build();
    }
}
