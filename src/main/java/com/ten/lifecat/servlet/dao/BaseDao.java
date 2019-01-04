package com.ten.lifecat.servlet.dao;

import java.util.List;

/**
 * 统一定义数据库操作，通过泛型Entity，实现对不同实体的操作，具体实现请在IMPL中实现。
 */
public interface BaseDao<Entity> {
    /**
     * 插入
     */
    int insert(Entity pojo);

    /**
     * 查询
     */
    List<Entity> select(Entity pojo);

    /**
     * 更新
     */
    int update(Entity pojo);

    /**
     * 删除
     */
    int delete(Entity pojo);
}
