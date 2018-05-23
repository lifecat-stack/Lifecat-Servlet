package com.wang.dao.jdbcimpl;

import com.wang.bean.Image;
import com.wang.dao.dao.ImageDAO;
import com.wang.doo.ImageDO;
import com.wang.util.Connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * UserDAO -- jdbc实现类
 *
 * @auther ten
 */
class ImageDAOImpl extends AbstractDAO implements ImageDAO {

    private ImageDAOImpl() {
    }

    static ImageDAO newImageDAO() {
        return new ImageDAOImpl();
    }


    /**
     * 查询image queryImage(userid,image_id)
     *
     * @param user_id  user_id
     * @param image_id image_id
     * @return Image 数据库返回Image对象
     * @throws SQLException         SQL异常
     * @throws NullPointerException 数据库查询为空
     */
    public Image queryImage(int user_id, int image_id) throws SQLException {

        String sql = "select * from image where user_id = " + user_id + " and image_id = " + image_id;

        ResultSet resultSet;

        Connection connection = Connections.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        resultSet = preparedStatement.executeQuery();

        if (resultSet == null) {
            throw new NullPointerException();
        }

        String image_name = resultSet.getString("image_name");
        String image_date = resultSet.getString("image_date");
        String image_path = resultSet.getString("image_path");
        String image_type = resultSet.getString("image_type");

        return new Image.Builder(image_path).image_id(image_id).image_name(image_name).image_date(image_date).image_type(image_type).build();
    }

    /**
     * 插入image insertImage(userid,Image)
     *
     * @param image Image
     * @throws SQLException SQL异常
     */
    public void insertImage(int userid, Image image) throws SQLException {

        String sql = "insert into image values(?,?,?,?,?,?)";

        Connection connection = Connections.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, userid);
        preparedStatement.setInt(2, image.getImage_id());
        preparedStatement.setString(3, image.getImage_name());
        preparedStatement.setString(4, image.getImage_date());
        preparedStatement.setString(5, image.getImage_path());
        preparedStatement.setString(6, image.getImage_type());

        preparedStatement.executeUpdate();
    }

    /**
     * 获取全部images queryImages(user_id)
     *
     * @param user_id user_id
     * @return List Image 数据库返回Image数据集
     * @throws SQLException         SQL异常
     * @throws NullPointerException 数据库查询为空
     */
    public List<Image> queryImages(int user_id) throws SQLException {

        String sql = "select * from image where id = " + user_id;

        ResultSet resultSet;

        Connection connection = Connections.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        resultSet = preparedStatement.executeQuery();

        if (resultSet == null) {
            throw new NullPointerException();
        }

        List<Image> list = new ArrayList<>();

        //获取数据库返回数据集
        getImageList(resultSet, list);

        return list;
    }

    /**
     * 获取分类images queryClasses(user_id,type)
     *
     * @param user_id user_id
     * @param type    type
     * @return List Image 数据库返回Image数据集
     * @throws SQLException         SQL异常
     * @throws NullPointerException 数据库查询为空
     */
    public List<Image> queryClasses(int user_id, String type) throws SQLException {

        String sql = "select * from image where type = " + type + " and id = " + user_id;

        ResultSet resultSet;

        Connection connection = Connections.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        resultSet = preparedStatement.executeQuery();

        if (resultSet == null) {
            throw new NullPointerException();
        }

        List<Image> list = new ArrayList<>();

        //获取数据库返回数据集
        getImageList(resultSet, list);

        return list;
    }

    /**
     * 从ResultSet获取List
     *
     * @param resultSet 返回结果集
     * @param list      Image数据集
     * @throws SQLException ResultSet异常
     */
    private void getImageList(ResultSet resultSet, List<Image> list) throws SQLException {
        int image_id;
        String image_name;
        String image_date;
        String image_path;
        String image_type;

        while (resultSet.next()) {
            image_id = resultSet.getInt("image_id");
            image_name = resultSet.getString("image_name");
            image_date = resultSet.getString("image_date");
            image_path = resultSet.getString("image_path");
            image_type = resultSet.getString("image_type");
            list.add(new Image.Builder(image_path).image_name(image_name).image_date(image_date)
                    .image_type(image_type).image_id(image_id).build());
        }
    }

    @Override
    public int insertImage(ImageDO imageDO) throws SQLException {
        return 0;
    }

    @Override
    public void deleteImage(int imageId) throws SQLException {

    }

    @Override
    public void updateImageText(int imageId, String newText) throws SQLException {

    }

    @Override
    public ImageDO queryImage(String imageName) throws SQLException {
        return null;
    }

    @Override
    public List<ImageDO> queryImageList(int userId) throws SQLException {
        return null;
    }

    @Override
    public List<ImageDO> queryImageClass(int userId, int classId) throws SQLException {
        return null;
    }
}
