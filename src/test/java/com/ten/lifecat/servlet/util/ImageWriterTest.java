package com.ten.lifecat.servlet.util;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static junit.framework.TestCase.assertNotNull;

/**
 * ImageWriter Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>六月 16, 2018</pre>
 */
public class ImageWriterTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: newImageWriter(String imagePath)
     */
    @Test
    public void testNewImageWriter() throws Exception {
        ImageWriter writer = ImageWriter.newImageWriter("test");
        assertNotNull(writer);
    }

    /**
     * Method: writeImage(InputStream stream)
     */
    @Test
    public void testWriteImage() throws Exception {
        //TODO: 测试图片上传功能
    }


    /**
     * Method: getEndPosition(RandomAccessFile random, long endPosition, long mark, int j)
     */
    @Test
    public void testGetEndPosition() throws Exception {
    }
} 
