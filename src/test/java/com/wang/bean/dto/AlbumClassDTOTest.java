package com.wang.bean.dto;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;

/**
 * AlbumClassDTO Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÁùÔÂ 17, 2018</pre>
 */
public class AlbumClassDTOTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: newAlbumClass(int userId, int imageClassId)
     */
    @Test
    public void testNewAlbumClass() throws Exception {
        AlbumClassDTO albumClassDTO1 = AlbumClassDTO.newAlbumClass(17, 1);
        AlbumClassDTO albumClassDTO2 = AlbumClassDTO.newAlbumClass(17, 1);
        assertEquals(albumClassDTO1.toString(), albumClassDTO2.toString());
    }

    /**
     * Method: addImage(ImageDTO image)
     */
    @Test
    public void testAddImage() throws Exception {
        AlbumClassDTO albumClassDTO = AlbumClassDTO.newAlbumClass(17, 1);
        ImageDTO imageDTO = new ImageDTO.Builder(1, "path", "date").build();
        albumClassDTO.addImage(imageDTO);
        assertEquals(imageDTO, albumClassDTO.getImageClassList().get(0));
    }

    /**
     * Method: getImageClassList()
     */
    @Test
    public void testGetImageClassList() throws Exception {
        AlbumClassDTO albumClassDTO = AlbumClassDTO.newAlbumClass(17, 1);
        ImageDTO imageDTO = new ImageDTO.Builder(1, "path", "date").build();
        albumClassDTO.addImage(imageDTO);
        assertEquals(imageDTO, albumClassDTO.getImageClassList().get(0));
        assert albumClassDTO.getImageClassList().size() == 1;
    }

    /**
     * Method: toString()
     */
    @Test
    public void testToString() throws Exception {
    }
} 
