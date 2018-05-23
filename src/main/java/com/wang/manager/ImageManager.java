package com.wang.manager;

import com.wang.bean.Image;
import com.wang.dao.jdbcimpl.DAOFactory;
import com.wang.dao.jdbcimpl.ImageDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * ImageManager: image表操作
 * <p>
 * 访问范围: 全局
 * 调用者: Service
 * 异常检测: 确保DAO参数无差错
 * <p>
 * 1. 查询image queryImage(image_id)
 * 2. 插入image insertImage(Image)
 * 3. 获取全部images queryImages(user_id)
 * 4. 获取分类images queryClasses(class)
 *
 * @auther ten
 */
public class ImageManager implements Manager {
    private final int userid;
    private final ImageDAO dao;
    private final Logger logger;

    private ImageManager(int userid) {
        this.userid = userid;
        this.dao = (ImageDAO) DAOFactory.getDAOByName("ImageDAO");
        this.logger = Logger.getLogger("ImageManager@" + userid);
    }

    static Manager getImageModel(int userid) {
        return new ImageManager(userid);
    }

    /**
     * 查询image by image_id
     *
     * @param image_id image_id
     * @return Image Image对象
     * @throws SQLException         queryImage()异常
     * @throws NullPointerException 数据库查询为空
     */
    public Image queryImage(int image_id) throws SQLException {
        logger.info("queryImage()");

        return dao.queryImage(userid, image_id);
    }

    /**
     * 插入image to (image)
     *
     * @throws SQLException             insertImage()异常
     * @throws IllegalArgumentException image属性为空
     */
    public void insertImage(Image image) throws SQLException {
        logger.info("insertImage()");

        final boolean isNull = image.getImage_name() == null || image.getImage_date() == null || image.getImage_path() == null || image.getImage_type() == null;

        if (isNull) {
            throw new IllegalArgumentException("image argument is null");
        }

        dao.insertImage(userid, image);
    }

    /**
     * 获取images by user_id
     *
     * @return List Image集合
     * @throws SQLException         queryImages()异常
     * @throws NullPointerException 数据库查询为空
     */
    public List<Image> queryImages(int user_id) throws SQLException {
        logger.info("queryImages()");

        List<Image> list;

        list = dao.queryImages(user_id);

        //若List为空, 用空集合代替Null
        if (list.size() == 0) {
            return new ArrayList<>();
        }

        return list;
    }

    /**
     * 获取images by classes
     *
     * @param type Image类别
     * @return List Image集合
     * @throws SQLException         queryClasses()异常
     * @throws NullPointerException 数据库查询为空
     */
    public List<Image> queryClasses(String type) throws SQLException {
        logger.info("queryClasses()");

        List<Image> list;

        list = dao.queryClasses(userid, type);

        //若List为空, 用空集合代替Null
        if (list.size() == 0) {
            return new ArrayList<>();
        }

        return list;
    }
}
