package com.wang.service;

import com.wang.bean.User;
import com.wang.daomanager.DAOModelFactory;
import com.wang.daomanager.UserMsgDAOModel;
import com.wang.util.HOST;
import com.wang.util.ImageWriter;
import com.wang.util.MyDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * UpUserIconModel: 上传头像图片到服务器, 并加载路径到usermsg数据库
 * <p>
 * 访问范围: 全局
 * 调用者: Servlet
 * 异常检测: try-catch异常处理层
 * <p>
 * 1. 获取DAOModel
 * 2. 上传图片到userid目录下
 * 3. 写入路径到数据库
 *
 * @auther ten
 */
public class UpUserIconModel implements ServiceModel {
    private Logger logger;

    private UpUserIconModel() {
        logger = Logger.getLogger("UpUserIconModel");
    }

    static ServiceModel getModel() {
        return new UpUserIconModel();
    }

    /**
     * 上传icon到服务器并写入数据库
     *
     * @param req  file 二进制请求
     * @param resp 响应
     */
    @Override
    public ModelResult execute(HttpServletRequest req, HttpServletResponse resp) {

        User user = (User) req.getSession().getAttribute("user");

        //tomcat/webapps/image/userid/icon/
        String directory_path = HOST.IMAGE_PATH + user.getId() + "/icon/";

        //检查目录是否存在
        File directory = new File(directory_path);
        if (!directory.exists()) {
            directory.mkdir();
        }

        //1. 将图片写入服务器
        String image_path = directory_path + MyDate.getInstance().getCurrentTime() + ".jpg";
        ImageWriter writer = ImageWriter.newImageWriter(image_path);

        try {
            writer.writeImage(req.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            return new ModelResult.Builder(true).errormsg("图片写入服务器失败").page(HOST.PAGE_UPIMAGE).build();
        }

        //2. 将路径写入数据库
        UserMsgDAOModel daoModel = (UserMsgDAOModel) DAOModelFactory.getDAOModelByName(user.getId(), "UserMsgDAOModel");

        try {
            daoModel.updateUserIcon(directory_path);
        } catch (SQLException e) {
            e.printStackTrace();
            return new ModelResult.Builder(true).errormsg("路径写入数据库失败").page(HOST.PAGE_UPIMAGE).build();
        }

        return new ModelResult.Builder(false).page(HOST.PAGE_IMAGESHOW).build();
    }
}
