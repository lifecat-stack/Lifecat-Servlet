package com.wang.bean.dto;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;

/**
 * AlbumDTO Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÁùÔÂ 17, 2018</pre>
 */
public class AlbumDTOTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: newAlbum(int userId)
     */
    @Test
    public void testNewAlbum() throws Exception {
        AlbumDTO albumDTO1 = AlbumDTO.newAlbum(17);
        AlbumDTO albumDTO2 = AlbumDTO.newAlbum(17);
        assertEquals(albumDTO1.toString(), albumDTO2.toString());
    }

    /**
     * Method: addImage(ImageDTO image)
     */
    @Test
    public void testAddImage() throws Exception {
        AlbumDTO albumDTO = AlbumDTO.newAlbum(17);
        ImageDTO imageDTO = new ImageDTO.Builder(1, "path", "date").build();
        albumDTO.addImage(imageDTO);
        assertEquals(imageDTO, albumDTO.getImageList().get(0));
    }

    /**
     * Method: getImageList()
     */
    @Test
    public void testGetImageList() throws Exception {
        AlbumDTO albumDTO = AlbumDTO.newAlbum(17);
        ImageDTO imageDTO = new ImageDTO.Builder(1, "path", "date").build();
        albumDTO.addImage(imageDTO);
        assertEquals(imageDTO, albumDTO.getImageList().get(0));
        assert albumDTO.getImageList().size() == 1;
    }

    /**
     * Method: toString()
     */
    @Test
    public void testToString() throws Exception {

    }
} 
