package com.ten.dao.mybatisimpl;


import com.ten.bean.entity.User;

import java.util.List;
import java.util.Map;


public interface UserMapper {
    List<User> selectUserList();

    User selectUserByName(Map<String, String> userMap);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUserById(int userId);
}
