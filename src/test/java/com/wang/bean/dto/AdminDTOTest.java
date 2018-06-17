package com.wang.bean.dto;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * AdminDTO Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÁùÔÂ 17, 2018</pre>
 */
public class AdminDTOTest {

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
        AdminDTO adminDTO1 = new AdminDTO.Builder(17, "wang", "admin").build();
        AdminDTO adminDTO2 = new AdminDTO.Builder(17, "wang", "admin").build();
        assertEquals(adminDTO1, adminDTO2);
    }

    /**
     * Method: hashCode()
     */
    @Test
    public void testHashCode() throws Exception {
        AdminDTO adminDTO1 = new AdminDTO.Builder(17, "wang", "admin").build();
        AdminDTO adminDTO2 = new AdminDTO.Builder(17, "wang", "admin").build();
        assertEquals(adminDTO1.hashCode(), adminDTO2.hashCode());
    }

    /**
     * Method: toString()
     */
    @Test
    public void testToString() throws Exception {
    }

    /**
     * Method: getAdminId()
     */
    @Test
    public void testGetAdminId() throws Exception {
        AdminDTO adminDTO = new AdminDTO.Builder(17, "wang", "admin").build();
        assert adminDTO.getAdminId() == 17;
    }

    /**
     * Method: getAdminName()
     */
    @Test
    public void testGetAdminName() throws Exception {
        AdminDTO adminDTO = new AdminDTO.Builder(17, "wang", "admin").build();
        assertEquals("wang", adminDTO.getAdminName());
    }

    /**
     * Method: getAdminLevel()
     */
    @Test
    public void testGetAdminLevel() throws Exception {
        AdminDTO adminDTO = new AdminDTO.Builder(17, "wang", "admin").build();
        assertEquals("admin", adminDTO.getAdminLevel());
    }

    /**
     * Method: build()
     */
    @Test
    public void testBuild() throws Exception {
        AdminDTO adminDTO = new AdminDTO.Builder(17, "wang", "admin").build();
        assert adminDTO.getAdminId() == 17;
        assertEquals("wang", adminDTO.getAdminName());
        assertEquals("admin", adminDTO.getAdminLevel());
    }
} 
