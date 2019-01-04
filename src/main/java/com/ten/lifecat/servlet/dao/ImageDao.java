package com.ten.lifecat.servlet.dao;

import com.ten.lifecat.servlet.entity.Image;

import java.util.List;

public interface ImageDao {

    int insert(Image pojo);

    int insertList(List<Image> pojo);

    List<Image> select(Image pojo);

    int update(Image pojo);

}
