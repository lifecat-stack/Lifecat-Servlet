package com.wang.service.serviceimpl;

import com.wang.bean.doo.DiaryDO;
import com.wang.bean.dto.UserDTO;
import com.wang.constant.Page;
import com.wang.dao.dao.DAOFactory;
import com.wang.dao.dao.DiaryDAO;
import com.wang.dao.jdbcimpl.JdbcDAOFactory;
import com.wang.service.service.Service;
import com.wang.util.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * 日记上传
 *
 * 失败 Page.PAGE_UPDIARY
 * 成功 Page.PAGE_USERHOME
 *
 * @date 2018/5/24
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
        String dateTime = DateTimeUtil.getInstance().getCurrentTime();

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
                    .page(Page.PAGE_UPDIARY)
                    .build();
        }

        return new ServiceResult.Builder(true)
                .page(Page.PAGE_USERHOME).build();
    }
}
