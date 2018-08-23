package com.ten.service.impl;

import com.ten.bean.entity.DiaryDO;
import com.ten.bean.vo.DiaryVO;
import com.ten.constant.WEBINF;
import com.ten.dao.DAOFactory;
import com.ten.dao.DiaryDAO;
import com.ten.dao.jdbcimpl.JdbcDAOFactory;
import com.ten.service.DiaryListQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 日记数据集获取
 * <p>
 * 失败 com.ten.constant.WEBINF.DIARY
 * 成功 Page.PAGE_DIARYSHOW
 *
 * @date 2018/5/24
 * @auther ten
 */
public class DiaryListQueryServiceImpl implements DiaryListQueryService {

    private Logger logger = LoggerFactory.getLogger(DiaryListQueryServiceImpl.class);

    private DiaryDAO dao;

    public DiaryListQueryServiceImpl() {
    }

    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {
        Integer userId = Integer.valueOf(req.getParameter("userId"));

        // 获取DAO实例
        DAOFactory factory = new JdbcDAOFactory();
        dao = (DiaryDAO) factory.getDaoByTableName("diary");

        List<DiaryDO> diaryDOList = null;
        boolean success = false;


        if (!success) {
            return new ServiceResult.Builder(false)
                    .errormsg("数据库查询异常")
                    .page(WEBINF.DIARY)
                    .build();
        }

        // List<DiaryVO>
        List<DiaryVO> diaryList = new ArrayList<>(16);
        for (DiaryDO diaryDO : diaryDOList) {
            DiaryVO diaryVO = new DiaryVO(
                    diaryDO.getDiaryId(),
                    diaryDO.getDiaryName(),
                    diaryDO.getdiaryText(),
                    diaryDO.getdiaryGmtModified());
            diaryList.add(diaryVO);
        }

        req.getSession().setAttribute("diaryList", diaryList);
        return new ServiceResult.Builder(true).page().build();
    }

    @Override
    public List<DiaryDO> queryDiaryListByUserId(int userId) {
        try {
            return dao.queryDiaryList(userId);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
