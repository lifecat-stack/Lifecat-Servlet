package com.wang.dao;

import java.sql.ResultSet;

/**
 * @name DAO
 * @description 数据库操作 增exeInsert 删exeDelete 改exeUpdate 查exeQuery
 * @auther ten
 */
public interface DAO {
    /**
     * @name insert
     * @description insert into "table" values("attributes")
     */
    boolean exeInsert(String table, Object[] attributes);

    /**
     * @name delete
     * @description delete from "table" where "attribute" = "value"
     */
    boolean exeDelete(String table, String attribute, String value);

    /**
     * @name update
     * @description update "table" set "attribute" = "value" where id = "id"
     */
    boolean exeUpdate(String table, String attribute, String value, int id);

    /**
     * @name query
     * @description select "attribute" from "table" where id = "id"
     */
    ResultSet exeSelect(String attribute, String table, int id);


}
