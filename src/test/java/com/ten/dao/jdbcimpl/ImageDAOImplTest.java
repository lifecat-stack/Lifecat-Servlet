package com.ten.dao.jdbcimpl;

import com.ten.bean.entity.Image;
import com.ten.dao.DAOFactory;
import com.ten.dao.ImageDAO;
import org.junit.*;

import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * ImageDAOImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÁùÔÂ 6, 2018</pre>
 */
public class ImageDAOImplTest {

    private static DAOFactory daoFactory;
    private ImageDAO dao;

    @BeforeClass
    public static void beforeClass() throws Exception {
        daoFactory = new JdbcDAOFactory();
    }

    @Before
    public void before() throws Exception {
        dao = (ImageDAO) daoFactory.getDaoByTableName("image");
        assertNotNull(dao);
    }

    @After
    public void after() throws Exception {
        dao = null;
    }

    @AfterClass
    public static void afterClass() throws Exception {
        daoFactory = null;
    }

    /**
     * Method: insertImage(Image imageDO)
     */
    @Test
    public void testInsertImage() throws Exception {
        Image image = new Image();
        assertNotNull(image);

        image.setImageText("this is test image");
        image.setImagePath("test path");
        image.setDeleted(1);
        image.setUserId(0);
        image.setClassId(0);
        image.setImageGmtCreate("2019-01-01 00:00:00");
        image.setImageGmtModified("2019-01-01 00:00:00");

        int key = dao.insertImage(image);
        assertNotEquals(key, 0);
    }

    /**
     * Method: deleteImage(int imageId)
     */
    @Test
    public void testDeleteImage() throws Exception {
        dao.deleteImage(4);
    }

    /**
     * Method: updateImageText(int imageId, String newText)
     */
    @Test
    public void testUpdateImageText() throws Exception {
        dao.updateImageText(5, "this is update");
    }

    /**
     * Method: queryImage(String imageName)
     */
    @Test
    public void testQueryImage() throws Exception {
        Image image = dao.queryImage(5);

        assertNotNull(image.getImageText());
        assertNotNull(image.getImagePath());
        assertNotNull(image.getImageGmtCreate());
    }

    /**
     * Method: queryImageList(int userId)
     */
    @Test
    public void testQueryImageList() throws Exception {
        List<Image> list = dao.queryImageList(0);
        assert list.size() >= 1;
    }

    /**
     * Method: queryImageClass(int userId, int classId)
     */
    @Test
    public void testQueryImageClass() throws Exception {
        List<Image> list = dao.queryImageClass(0, 0);
        assert list.size() >= 1;
    }


} 
