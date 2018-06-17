package com.wang.bean.dto;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;

/**
 * UserDTO Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÁùÔÂ 17, 2018</pre>
 */
public class UserDTOTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: equals(Object obj)
     */
    @Test
    public void testEquals() throws Exception {
        UserDTO userDTO1 = new UserDTO.Builder(17, "wang").build();
        UserDTO userDTO2 = new UserDTO.Builder(17, "wang").build();
        assertEquals(userDTO1, userDTO2);
    }

    /**
     * Method: hashCode()
     */
    @Test
    public void testHashCode() throws Exception {
        UserDTO userDTO1 = new UserDTO.Builder(17, "wang").build();
        UserDTO userDTO2 = new UserDTO.Builder(17, "wang").build();
        assertEquals(userDTO1.hashCode(), userDTO2.hashCode());
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
//TODO: Test goes here... 
    }

    /**
     * Method: getUserName()
     */
    @Test
    public void testGetUserName() throws Exception {
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
