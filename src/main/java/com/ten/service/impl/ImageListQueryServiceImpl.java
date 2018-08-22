package com.ten.service.impl;

import com.ten.bean.entity.ImageDO;
import com.ten.bean.vo.ImageVO;
import com.ten.bean.vo.UserVO;
import com.ten.constant.Page;
import com.ten.dao.DAOFactory;
import com.ten.dao.ImageDAO;
import com.ten.dao.jdbcimpl.JdbcDAOFactory;
import com.ten.service.ImageListQueryService;
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
class ImageListQueryServiceImpl implements ImageListQueryService {
    private Logger logger = LoggerFactory.getLogger(ImageListQueryServiceImpl.class);

    public ImageListQueryServiceImpl() {
    }

    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {
        UserVO userDTO = (UserVO) req.getSession().getAttribute("user");
        Integer userId = userDTO.getUserId();

        // 获取DAO实例
        DAOFactory factory = new JdbcDAOFactory();
        ImageDAO dao = (ImageDAO) factory.getDaoByTableName("image");

        List<ImageDO> imageDOList = null;
        boolean success = false;
        try {
            imageDOList = dao.queryImageList(userId);
            success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (!success) {
            return new ServiceResult.Builder(false)
                    .errormsg("数据库查询异常")
                    .page(Page.PAGE_USERHOME)
                    .build();
        }

        // List<ImageVO>
        List<ImageVO> imageList = new ArrayList<>(64);
        for (ImageDO imageDO : imageDOList) {
            ImageVO imageDTO = new ImageVO(
                    imageDO.getImageId())
                    .imagePath(imageDO.getImagePath())
                    .imageDate(imageDO.getImageGmtCreate())
                    .imageText(imageDO.getImageText())
                    .imageClassId(imageDO.getClassId());
            imageList.add(imageDTO);
        }

        req.getSession().setAttribute("imageList", imageList);
        return new ServiceResult.Builder(true)
                .page(Page.PAGE_IMAGESHOW)
                .build();
    }

    @Override
    public List<ImageDO> queryImageListByUserId(int userId) {
        return null;
    }
}
