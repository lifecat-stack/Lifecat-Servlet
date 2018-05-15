package test.com.wang.dao;

import com.wang.dao.DAO;
import com.wang.dao.DAOFactory;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * DAOFactory Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÎåÔÂ 15, 2018</pre>
 */
public class DAOFactoryTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getDAOByName(String name)
     */
    @Test
    public void testGetDAOByName() throws Exception {
//TODO: Test goes here...
        DAO dao = DAOFactory.getDAOByName("UserDAO");
        assert dao != null;
    }


} 
