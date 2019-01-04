package com.ten.lifecat.servlet.dao;

import com.ten.lifecat.servlet.entity.ImageClass;

import java.util.List;

public interface ImageClassDao {

    int insert(ImageClass pojo);

    int insertList(List<ImageClass> pojo);

    List<ImageClass> select(ImageClass pojo);

    int update(ImageClass pojo);

}
