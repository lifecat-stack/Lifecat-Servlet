package com.wang.service.serviceimpl;

import com.wang.constant.HOST;
import com.wang.dao.dao.DAOFactory;
import com.wang.dao.dao.DiaryDAO;
import com.wang.dao.jdbcimpl.JdbcDAOFactory;
import com.wang.bean.doo.DiaryDO;
import com.wang.bean.dto.DiaryDTO;
import com.wang.bean.dto.UserDTO;
import com.wang.service.service.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    private Logger logger = LoggerFactory.getLogger(DiaryListQuery.class);

    private DiaryListQuery() {
    }

    static Service newService() {
        return new DiaryListQuery();
    }

    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {

        UserDTO userDTO = (UserDTO) req.getSession().getAttribute("user");
        Integer userId = userDTO.getUserId();

        // 获取DAO实例
        DAOFactory factory = new JdbcDAOFactory();
        DiaryDAO dao = factory.getDiaryDAO();

        List<DiaryDO> diaryDOList = null;
        boolean success = false;
        try {
            diaryDOList = dao.queryDiaryList(userId);
            success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (!success) {
            return new ServiceResult.Builder(true)
                    .errormsg("数据库查询异常")
                    .page(req.getRequestURI())
                    .build();
        }

        // List<DiaryDTO>
        List<DiaryDTO> diaryList = new ArrayList<>(16);
        for (DiaryDO diaryDO : diaryDOList) {
            DiaryDTO diaryDTO = new DiaryDTO.Builder(diaryDO.getDiaryId())
                    .diaryName(diaryDO.getDiaryName())
                    .diaryText(diaryDO.getdiaryText())
                    .diaryDate(diaryDO.getdiaryGmtModified())
                    .build();
            diaryList.add(diaryDTO);
        }

        req.setAttribute("diaryList", diaryList);
        return new ServiceResult.Builder(true)
                .page(HOST.PAGE_USERHOME)
                .build();
    }
}
