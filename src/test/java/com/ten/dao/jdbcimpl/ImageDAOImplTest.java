package com.ten.dao.jdbcimpl;

import com.ten.bean.entity.ImageDO;
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
     * Method: insertImage(ImageDO imageDO)
     */
    @Test
    public void testInsertImage() throws Exception {
        ImageDO imageDO = new ImageDO();
        assertNotNull(imageDO);

        imageDO.setImageText("this is test image");
        imageDO.setImagePath("test path");
        imageDO.setDeleted(1);
        imageDO.setUserId(0);
        imageDO.setClassId(0);
        imageDO.setImageGmtCreate("2019-01-01 00:00:00");
        imageDO.setImageGmtModified("2019-01-01 00:00:00");

        int key = dao.insertImage(imageDO);
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
        ImageDO imageDO = dao.queryImage(5);

        assertNotNull(imageDO.getImageText());
        assertNotNull(imageDO.getImagePath());
        assertNotNull(imageDO.getImageGmtCreate());
    }

    /**
     * Method: queryImageList(int userId)
     */
    @Test
    public void testQueryImageList() throws Exception {
        List<ImageDO> list = dao.queryImageList(0);
        assert list.size() >= 1;
    }

    /**
     * Method: queryImageClass(int userId, int classId)
     */
    @Test
    public void testQueryImageClass() throws Exception {
        List<ImageDO> list = dao.queryImageClass(0, 0);
        assert list.size() >= 1;
    }


} 
