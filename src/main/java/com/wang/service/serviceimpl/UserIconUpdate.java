package com.wang.service.serviceimpl;

import com.wang.bean.doo.UserIconDO;
import com.wang.bean.dto.UserDTO;
import com.wang.constant.Directory;
import com.wang.constant.Page;
import com.wang.dao.dao.DAOFactory;
import com.wang.dao.dao.UserIconDAO;
import com.wang.dao.jdbcimpl.JdbcDAOFactory;
import com.wang.service.Service;
import com.wang.util.DateTimeUtil;
import com.wang.util.ImageWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 用户头像上传
 *
 * 失败 Page.PAGE_USERHOME
 * 成功 Page.PAGE_USERHOME
 *
 * @date 2018/5/24
 * @auther ten
 */
 class UserIconUpdate implements Service {
 private Logger logger = LoggerFactory.getLogger(UserIconUpdate.class);

    private UserIconUpdate() {
    }

    static Service newService() {
        return new UserIconUpdate();
    }
    /**
     * 上传icon到服务器并写入数据库
     *
     * @param req  file 二进制请求
     * @param resp 响应
     */
    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {

        UserDTO userDTO = (UserDTO) req.getSession().getAttribute("user");
        Integer userId = userDTO.getUserId();
        String dateTime = DateTimeUtil.getInstance().getCurrentTime();

        String iconPath = Directory.IMAGE_PATH + String.valueOf(userId) + "/icon/"
                + dateTime;
        ImageWriter writer = ImageWriter.newImageWriter(iconPath);

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
                    .page(Page.PAGE_USERHOME)
                    .build();
        }

        // 将图片信息写入数据库
        // 获取DAO实例
        DAOFactory factory = new JdbcDAOFactory();
        UserIconDAO dao = factory.getUserIconDAO();


        UserIconDO userIconDO = new UserIconDO();
        userIconDO.setUserId(userId);
        userIconDO.setIconPath(iconPath);
        userIconDO.setIconGmtCreate(dateTime);
        userIconDO.setIconGmtModified(dateTime);

        boolean success2 = false;
        try {
            dao.insertUserIcon(userIconDO);
            success2 = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (!success2) {
            return new ServiceResult.Builder(false)
                    .errormsg("数据库插入异常")
                    .page(Page.PAGE_USERHOME)
                    .build();
        }

        return new ServiceResult.Builder(true)
                .page(Page.PAGE_USERHOME)
                .build();
    }
}
