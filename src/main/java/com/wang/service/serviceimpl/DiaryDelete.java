package com.wang.service.serviceimpl;

import com.wang.constant.HOST;
import com.wang.dao.dao.DAOFactory;
import com.wang.dao.dao.DiaryDAO;
import com.wang.dao.jdbcimpl.JdbcDAOFactory;
import com.wang.service.service.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * 日记删除
 *
 * @date 2018/5/24
 * @auther ten
 */
public class DiaryDelete implements Service {
     private Logger logger = LoggerFactory.getLogger(DiaryDelete.class);

    private DiaryDelete() {
    }

    static Service newService() {
        return new DiaryDelete();
    }
    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {

        String diaryId = req.getParameter("diaryId");

        // 获取DAO实例
        DAOFactory factory = new JdbcDAOFactory();
        DiaryDAO dao = factory.getDiaryDAO();

        boolean success = false;
        try {
            dao.deleteDiary(Integer.valueOf(diaryId));
            success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (!success) {
            return new ServiceResult.Builder(true)
                    .errormsg("日记删除失败").page(req.getRequestURI()).build();
        }

        return new ServiceResult.Builder(true).page(HOST.PAGE_USERHOME).build();
    }
}
