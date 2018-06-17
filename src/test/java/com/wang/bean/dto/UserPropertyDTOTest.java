package com.wang.bean.dto;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;

/**
 * UserPropertyDTO Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÁùÔÂ 17, 2018</pre>
 */
public class UserPropertyDTOTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: toString()
     */
    @Test
    public void testToString() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getUserId()
     */
    @Test
    public void testGetUserId() throws Exception {
        UserPropertyDTO userPropertyDTO = new UserPropertyDTO.Builder(17).build();
        assert userPropertyDTO.getUserId() == 17;
    }

    /**
     * Method: getNickname()
     */
    @Test
    public void testGetNickname() throws Exception {
        UserPropertyDTO userPropertyDTO = new UserPropertyDTO.Builder(17).nickname("test").build();
        assertEquals("test", userPropertyDTO.getNickname());
    }

    /**
     * Method: getSignature()
     */
    @Test
    public void testGetSignature() throws Exception {
        UserPropertyDTO userPropertyDTO = new UserPropertyDTO.Builder(17).signature("test").build();
        assertEquals("test", userPropertyDTO.getSignature());
    }

    /**
     * Method: getEmail()
     */
    @Test
    public void testGetEmail() throws Exception {
        UserPropertyDTO userPropertyDTO = new UserPropertyDTO.Builder(17).email("test").build();
        assertEquals("test", userPropertyDTO.getEmail());
    }

    /**
     * Method: getSex()
     */
    @Test
    public void testGetSex() throws Exception {
        UserPropertyDTO userPropertyDTO = new UserPropertyDTO.Builder(17).sex("test").build();
        assertEquals("test", userPropertyDTO.getSex());
    }

    /**
     * Method: getLocation()
     */
    @Test
    public void testGetLocation() throws Exception {
        UserPropertyDTO userPropertyDTO = new UserPropertyDTO.Builder(17).location("test").build();
        assertEquals("test", userPropertyDTO.getLocation());
    }

    /**
     * Method: getBirthday()
     */
    @Test
    public void testGetBirthday() throws Exception {
        UserPropertyDTO userPropertyDTO = new UserPropertyDTO.Builder(17).birthday("test").build();
        assertEquals("test", userPropertyDTO.getBirthday());
    }

    /**
     * Method: getIconPath()
     */
    @Test
    public void testGetIconPath() throws Exception {
        UserPropertyDTO userPropertyDTO = new UserPropertyDTO.Builder(17).iconPath("test").build();
        assertEquals("test", userPropertyDTO.getIconPath());
    }

    /**
     * Method: nickname(String val)
     */
    @Test
    public void testNickname() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: signature(String val)
     */
    @Test
    public void testSignature() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: email(String val)
     */
    @Test
    public void testEmail() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: sex(String val)
     */
    @Test
    public void testSex() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: location(String val)
     */
    @Test
    public void testLocation() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: birthday(String val)
     */
    @Test
    public void testBirthday() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: iconPath(String val)
     */
    @Test
    public void testIconPath() throws Exception {
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
