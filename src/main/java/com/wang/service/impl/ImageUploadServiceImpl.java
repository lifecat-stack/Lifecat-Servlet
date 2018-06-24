package com.wang.service.impl;

import com.wang.bean.doo.ImageDO;
import com.wang.bean.dto.UserDTO;
import com.wang.constant.Directory;
import com.wang.constant.Page;
import com.wang.dao.DAOFactory;
import com.wang.dao.ImageDAO;
import com.wang.dao.jdbcimpl.JdbcDAOFactory;
import com.wang.service.util.Service;
import com.wang.util.DateTimeUtil;
import com.wang.util.ImageWriter;
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
class ImageUploadServiceImpl implements ImageUploadService {
    private Logger logger = LoggerFactory.getLogger(ImageUploadServiceImpl.class);

    private ImageUploadServiceImpl() {
    }

    static Service newService() {
        return new ImageUploadServiceImpl();
    }

    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {

        UserDTO userDTO = (UserDTO) req.getSession().getAttribute("user");
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
        ImageDAO dao = factory.getImageDAO();

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
}
