package com.ten.lifecat.servlet.dao.jdbcimpl;

import com.ten.lifecat.servlet.dao.AdminDao;
import com.ten.lifecat.servlet.dao.BaseDaoImpl;
import com.ten.lifecat.servlet.entity.Admin;
import com.ten.lifecat.servlet.dao.AdminDao;
import com.ten.lifecat.servlet.dao.BaseDaoImpl;
import com.ten.lifecat.servlet.entity.Admin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;

/**
 * TODO dao impl 类似于 mapper.xml 进行开发
 */
public class AdminDAOImpl extends BaseDaoImpl implements AdminDao {
    private static final Logger logger = LoggerFactory.getLogger(AdminDAOImpl.class);

    private static final String ALL_COLUMN =
            "(id, admin_name, admin_password, admin_level, create_time, update_time, is_deleted)";

    private static final String INSERT_SQL =
            "insert into admin " + ALL_COLUMN + "values(?,?,?,?,?,?,?)";

    @Override
    public int insert(Admin pojo) {
        Object[] args = {
                pojo.getId(),
                pojo.getAdminName(),
                pojo.getAdminPassword(),
                pojo.getAdminLevel(),
                pojo.getCreateTime(),
                pojo.getUpdateTime(),
                pojo.getIsDeleted()};

        return insert(INSERT_SQL, args);
    }

    private static final String UPDATE_SQL =
            "update admin " + ALL_COLUMN + "values(?,?,?,?,?,?,?)";

    @Override
    public int update(Admin pojo) {
        Object[] args = {
                pojo.getId(),
                pojo.getAdminName(),
                pojo.getAdminPassword(),
                pojo.getAdminLevel(),
                pojo.getCreateTime(),
                pojo.getUpdateTime(),
                pojo.getIsDeleted()};

        return update(UPDATE_SQL, args);
    }

    private static final String SELECT_SQL =
            "select " + ALL_COLUMN + "from admin where 1=1 ";

    /**
     * TODO 动态增加where字段
     */
    @Override
    public List<Admin> select(Admin pojo) {
        Object[] args = {
                pojo.getAdminName(), pojo.getAdminPassword(), pojo.getAdminLevel(),
                pojo.getCreateTime(), pojo.getUpdateTime(), pojo.getIsDeleted()};

        StringBuilder builder = new StringBuilder();
        builder.append(SELECT_SQL);

        if (pojo.adminName != null) {
            builder.append(",admin_name = \'").append(pojo.adminName).append("\'");
        }

        // TODO 能否通过FIELD实现动态拼接
        Arrays.stream(pojo.getClass().getFields()).forEach((field -> {
            if (field != null) {
                builder.append("," + field.getName() + "=" + field.getName());
            }
        }));


        ResultSet resultSet = query(SELECT_SQL, args);
        return null;
    }

    private static final String DELETE_SQL =
            "update admin set is_deleted = ? ";

    @Override
    public int delete(Admin pojo) {
        return update(DELETE_SQL, new Object[]{1});
    }
}
