package com.ten.service.impl;

import com.ten.bean.entity.ImageDO;
import com.ten.bean.vo.UserVO;
import com.ten.constant.Directory;
import com.ten.constant.Page;
import com.ten.dao.DAOFactory;
import com.ten.dao.ImageDAO;
import com.ten.dao.jdbcimpl.JdbcDAOFactory;
import com.ten.service.ImageUploadService;
import com.ten.util.DateTimeUtil;
import com.ten.util.ImageWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 图片上传
 * <p>
 * 失败 Page.PAGE_UPIMAGE
 * 成功 Page.PAGE_USERHOME
 *
 * @date 2018/5/24
 * @auther ten
 */
public class ImageUploadServiceImpl implements ImageUploadService {
    private Logger logger = LoggerFactory.getLogger(ImageUploadServiceImpl.class);

    public ImageUploadServiceImpl() {
    }

    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {

        UserVO userDTO = (UserVO) req.getSession().getAttribute("user");
        Integer userId = userDTO.getUserId();
        String dateTime = DateTimeUtil.getInstance().getCurrentTime();

        String imagePath = Directory.IMAGE_PATH + String.valueOf(userId) + "/image/"
                + dateTime;
        ImageWriter writer = ImageWriter.newImageWriter(imagePath);

        // 将图片数据流写入磁盘
        boolean success = false;
        try {
            writer.writeImage(req.getInputStream());
            success = true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!success) {
            return new ServiceResult.Builder(false)
                    .errormsg("数据流写入失败")
                    .page(Page.PAGE_UPIMAGE)
                    .build();
        }

        String imageText = req.getParameter("imageText");

        // 将图片信息写入数据库
        // 获取DAO实例
        DAOFactory factory = new JdbcDAOFactory();
        ImageDAO dao = (ImageDAO) factory.getDaoByTableName("image");

        ImageDO imageDO = new ImageDO();
        imageDO.setUserId(userId);
        imageDO.setClassId(0);
        imageDO.setDeleted(1);
        imageDO.setImageText(imageText);
        imageDO.setImagePath(imagePath);
        imageDO.setImageGmtCreate(dateTime);
        imageDO.setImageGmtModified(dateTime);
        boolean success2 = false;
        try {
            dao.insertImage(imageDO);
            success2 = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (!success2) {
            return new ServiceResult.Builder(false)
                    .errormsg("数据库插入异常")
                    .page(Page.PAGE_UPIMAGE)
                    .build();
        }

        return new ServiceResult.Builder(true)
                .page(Page.PAGE_IMAGESHOW)
                .build();
    }

    @Override
    public void uploadImage(ImageDO imageDO) {

    }
}
