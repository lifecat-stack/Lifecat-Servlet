package com.wang.service.serviceimpl;

import com.wang.constant.HOST;
import com.wang.dao.dao.DAOFactory;
import com.wang.dao.dao.DiaryDAO;
import com.wang.dao.jdbcimpl.JdbcDAOFactory;
import com.wang.bean.doo.DiaryDO;
import com.wang.bean.dto.UserDTO;
import com.wang.service.service.Service;
import com.wang.util.MyDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

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

    private Logger logger = LoggerFactory.getLogger(DiaryUpload.class);

    private DiaryUpload() {
    }

    static Service newService() {
        return new DiaryUpload();
    }

    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {
        // userId
        UserDTO userDTO = (UserDTO) req.getSession().getAttribute("user");
        Integer userId = userDTO.getUserId();
        // form参数
        String diaryName = req.getParameter("diaryName");
        String diaryText = req.getParameter("diaryText");
        // 时间
        String dateTime = MyDate.getInstance().getCurrentTime();

        // 获取DAO实例
        DAOFactory factory = new JdbcDAOFactory();
        DiaryDAO dao = factory.getDiaryDAO();

        DiaryDO diaryDO = new DiaryDO();
        diaryDO.setDiaryId(userId);
        diaryDO.setDiaryName(diaryName);
        diaryDO.setdiaryText(diaryText);
        diaryDO.setDeleted(1);
        diaryDO.setdiaryGmtCreate(dateTime);
        diaryDO.setdiaryGmtModified(dateTime);

        boolean success = false;
        try {
            dao.insertDiary(diaryDO);
            success=true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

         if (!success) {
            return new ServiceResult.Builder(false)
                    .errormsg("数据库插入异常")
                    .page(req.getRequestURI())
                    .build();
        }

        return new ServiceResult.Builder(true)
                .page(HOST.PAGE_USERHOME).build();
    }
}
