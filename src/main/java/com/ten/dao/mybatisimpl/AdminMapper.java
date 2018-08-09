package com.ten.dao.mybatisimpl;

import com.ten.bean.entity.AdminDO;

import java.util.List;
import java.util.Map;


public interface AdminMapper {
    List<AdminDO> selectAdminList();

    AdminDO selectAdminByName(Map<String, String> adminMap);

    int insertAdmin(AdminDO adminDO);

    int updateAdmin(AdminDO adminDO);

    int deleteAdminById(int adminId);
}