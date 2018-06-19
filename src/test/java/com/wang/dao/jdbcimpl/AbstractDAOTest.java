package com.wang.dao.jdbcimpl;

import com.wang.util.Connections;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import static junit.framework.TestCase.assertNotNull;

/**
 * AbstractDAO Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÁùÔÂ 19, 2018</pre>
 */
public class AbstractDAOTest {

    private static Connection conn;

    @BeforeClass
    public static void before() throws Exception {
        conn = Connections.getConnection();
        assertNotNull(conn);
    }

    @AfterClass
    public static void after() throws Exception {
        conn = null;
    }

    /**
     * Method: insert(String sql, Object[] args)
     */
    @Test
    public void testInsert() throws Exception {
        String sql = "INSERT INTO test(test_name,test_text,test_gmt_create,test_gmt_modified)"
                + " VALUES (?,?,?,?)";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setObject(1, "test02");
        preparedStatement.setObject(2, "this is test ");
        preparedStatement.setObject(3, "2018-06-18 14:09:11");
        preparedStatement.setObject(4, "2018-06-18 14:09:11");

        preparedStatement.executeUpdate();
    }

    /**
     * Method: delete(String sql)
     */
    @Test
    public void testDelete() throws Exception {

        String sql = "DELETE FROM test"
                + " WHERE test_id = '1'";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.executeUpdate();
    }

    /**
     * Method: update(String sql)
     */
    @Test
    public void testUpdate() throws Exception {

        String sql = "UPDATE test SET test_text = 'this is update test',test_gmt_modified = '2019-01-01 00:00:00'"
                + " WHERE test_id = '1'";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.executeUpdate();
    }

    /**
     * Method: query(String sql)
     */
    @Test
    public void testQuery() throws Exception {
        String sql = "SELECT test_id,test_text,test_gmt_create,test_gmt_modified FROM"
                + " test WHERE test_name = 'test'";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();

        assertNotNull(resultSet.getString("test_text"));
        assertNotNull(resultSet.getString("test_gmt_create"));
        assertNotNull(resultSet.getString("test_gmt_modified"));
    }

    /**
     * Method: insertAndReturnKey(String sql, Object[] args)
     */
    @Test
    public void testInsertAndReturnKey() throws Exception {
        String sql = "INSERT INTO test(test_name,test_text,test_gmt_create,test_gmt_modified)"
                + " VALUES (?,?,?,?)";

        PreparedStatement preparedStatement = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setObject(1, "test11");
        preparedStatement.setObject(2, "this is test ");
        preparedStatement.setObject(3, "2018-06-18 14:09:11");
        preparedStatement.setObject(4, "2018-06-18 14:09:11");

        preparedStatement.executeUpdate();

        ResultSet rs = preparedStatement.getGeneratedKeys();
        rs.next();
        assertNotNull(rs.getInt(1));
    }
} 
