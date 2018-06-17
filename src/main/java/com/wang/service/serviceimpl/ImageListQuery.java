package com.wang.service.serviceimpl;

import com.wang.bean.doo.ImageDO;
import com.wang.bean.dto.ImageDTO;
import com.wang.bean.dto.UserDTO;
import com.wang.constant.Page;
import com.wang.dao.dao.DAOFactory;
import com.wang.dao.dao.ImageDAO;
import com.wang.dao.jdbcimpl.JdbcDAOFactory;
import com.wang.service.service.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 图片集合获取
 * <p>
 * 失败 Page.PAGE_USERHOME
 * 成功 Page.PAGE_IMAGESHOW
 *
 * @date 2018/5/24
 * @auther ten
 */
class ImageListQuery implements Service {
    private Logger logger = LoggerFactory.getLogger(ImageListQuery.class);

    private ImageListQuery() {
    }

    static Service newService() {
        return new ImageListQuery();
    }

    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {
        UserDTO userDTO = (UserDTO) req.getSession().getAttribute("user");
        Integer userId = userDTO.getUserId();

        // 获取DAO实例
        DAOFactory factory = new JdbcDAOFactory();
        ImageDAO dao = factory.getImageDAO();

        List<ImageDO> imageDOList = null;
        boolean success = false;
        try {
            imageDOList = dao.queryImageList(userId);
            success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (!success) {
            return new ServiceResult.Builder(true)
                    .errormsg("数据库查询异常")
                    .page(Page.PAGE_USERHOME)
                    .build();
        }

        // List<ImageDTO>
        List<ImageDTO> imageList = new ArrayList<>(64);
        for (ImageDO imageDO : imageDOList) {
            ImageDTO imageDTO = new ImageDTO.Builder(
                    imageDO.getImageId(),
                    imageDO.getImagePath(),
                    imageDO.getImageGmtCreate())
                    .imageText(imageDO.getImageText())
                    .imageClassId(imageDO.getClassId())
                    .build();
            imageList.add(imageDTO);
        }

        req.setAttribute("imageList", imageList);
        return new ServiceResult.Builder(true)
                .page(Page.PAGE_IMAGESHOW)
                .build();
    }
}
