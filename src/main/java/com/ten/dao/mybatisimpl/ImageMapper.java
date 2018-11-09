package com.ten.dao.mybatisimpl;


import com.ten.bean.entity.Image;

import java.util.List;
import java.util.Map;


public interface ImageMapper {

    Image selectImageByText(Map<String, String> map);

    List<Image> selectImageListByUserId(int userId);

    List<Image> selectImageListByClassId(Map<String, Integer> map);

    int insertImage(Image image);

    int updateImage(Image image);

    int deleteImageById(int imageId);
}
