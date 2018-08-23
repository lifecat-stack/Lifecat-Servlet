package com.ten.service.impl;

import com.ten.bean.entity.DiaryDO;
import com.ten.bean.vo.DiaryVO;
import com.ten.constant.Page;
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
 *
 * @date 2018/5/24
 * @auther ten
 */
public class DiaryListQueryServiceImpl implements DiaryListQueryService {

    private Logger logger = LoggerFactory.getLogger(DiaryListQueryServiceImpl.class);

    private DiaryDAO dao;

    public DiaryListQueryServiceImpl() {
        DAOFactory factory = new JdbcDAOFactory();
        dao = (DiaryDAO) factory.getDaoByTableName("diary");
    }

    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {
        Integer userId = Integer.valueOf(req.getParameter("userId"));

        List<DiaryDO> diaryDOList = queryDiaryListByUserId(userId);

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
        return new ServiceResult.Builder(true).page(Page.PAGE_USERHOME).build();
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
