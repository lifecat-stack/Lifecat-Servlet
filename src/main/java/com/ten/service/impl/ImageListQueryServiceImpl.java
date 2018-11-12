package com.ten.service.impl;

import com.ten.bean.entity.Image;
import com.ten.bean.vo.ImageVO;
import com.ten.constant.Page;
import com.ten.dao.ImageDAO;
import com.ten.dao.JdbcDAOFactory;
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
public class ImageListQueryServiceImpl implements ImageListQueryService {

    private Logger logger = LoggerFactory.getLogger(ImageListQueryServiceImpl.class);

    private ImageDAO dao;

    public ImageListQueryServiceImpl() {
        dao = (ImageDAO) JdbcDAOFactory.getDaoByTableName("image");
    }

    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {
        int userId = Integer.parseInt(req.getParameter("userId"));

        List<Image> imageDOList = queryImageListByUserId(userId);

        List<ImageVO> imageList = new ArrayList<>(16);
        for (Image image : imageDOList) {
            ImageVO imageDTO = new ImageVO(
                    image.getId())
                    .imagePath(image.getImagePath())
                    .imageDate(image.getCreateTime())
                    .imageText(image.getImageText());
            imageList.add(imageDTO);
        }

        req.getSession().setAttribute("imageList", imageList);
        return new ServiceResult.Builder(true).page(Page.PAGE_USERHOME).build();
    }

    @Override
    public List<Image> queryImageListByUserId(int userId) {
        try {
            return dao.queryImageList(userId);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
