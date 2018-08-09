package com.ten.dao.mybatisimpl;


import com.ten.bean.entity.ImageDO;

import java.util.List;
import java.util.Map;


public interface ImageMapper {

    ImageDO selectImageByText(Map<String, String> map);

    List<ImageDO> selectImageListByUserId(int userId);

    List<ImageDO> selectImageListByClassId(Map<String, Integer> map);

    int insertImage(ImageDO imageDO);

    int updateImage(ImageDO imageDO);

    int deleteImageById(int imageId);
}
