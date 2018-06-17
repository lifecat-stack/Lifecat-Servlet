package com.wang.bean.dto;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;

/**
 * ImageDTO Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÁùÔÂ 17, 2018</pre>
 */
public class ImageDTOTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: compareTo(ImageDTO img)
     */
    @Test
    public void testCompareTo() throws Exception {
        ImageDTO imageDTO1 = new ImageDTO.Builder(1, "test", "2018-03-01 00:00:00").build();
        ImageDTO imageDTO2 = new ImageDTO.Builder(2, "test", "2018-02-01 00:00:00").build();
        assert imageDTO1.compareTo(imageDTO2) > 0;
    }

    /**
     * Method: equals(Object obj)
     */
    @Test
    public void testEquals() throws Exception {
        ImageDTO imageDTO1 = new ImageDTO.Builder(1, "test", "2018-03-01 00:00:00").imageText("t").imageClassId(1).build();
        ImageDTO imageDTO2 = new ImageDTO.Builder(1, "test", "2018-03-01 00:00:00").imageText("t").imageClassId(1).build();
        assertEquals(imageDTO1, imageDTO2);
    }

    /**
     * Method: hashCode()
     */
    @Test
    public void testHashCode() throws Exception {
  ImageDTO imageDTO1 = new ImageDTO.Builder(1, "test", "2018-03-01 00:00:00").imageText("t").imageClassId(1).build();
        ImageDTO imageDTO2 = new ImageDTO.Builder(1, "test", "2018-03-01 00:00:00").imageText("t").imageClassId(1).build();
        assertEquals(imageDTO1.hashCode(), imageDTO2.hashCode());
       }

    /**
     * Method: toString()
     */
    @Test
    public void testToString() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getImageId()
     */
    @Test
    public void testGetImageId() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getImageText()
     */
    @Test
    public void testGetImageText() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getImagePath()
     */
    @Test
    public void testGetImagePath() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getImageDate()
     */
    @Test
    public void testGetImageDate() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getImageType()
     */
    @Test
    public void testGetImageType() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getHashCode()
     */
    @Test
    public void testGetHashCode() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: imageText(String val)
     */
    @Test
    public void testImageText() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: imageClassId(int val)
     */
    @Test
    public void testImageClassId() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: build()
     */
    @Test
    public void testBuild() throws Exception {
//TODO: Test goes here... 
    }


} 
