package com.wang.bean.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO :Album分类集合，不同类别图片集合
 *
 * @auther ten
 */
public class AlbumClassDTO {

    private final List<ImageDTO> imageClassList;
    private final Integer userId;
    private final Integer imageClassId;

    private AlbumClassDTO(int userId, int imageClassId) {
        this.userId = userId;
        this.imageClassId = imageClassId;
        imageClassList = new ArrayList<>();
    }

    public static AlbumClassDTO newAlbumClass(int userId, int imageClassId) {
        return new AlbumClassDTO(userId, imageClassId);
    }

    /**
     * 向List添加ImageDTO对象
     *
     * @param image ImageDTO对象
     */
    public void addImage(ImageDTO image) {
        imageClassList.add(image);
    }

    /**
     * {@literal 获取List<ImageDTO>}
     *
     * @return {@literal List<ImageDTO>}
     */
    public List<ImageDTO> getImageClassList() {
        return this.imageClassList;
    }

    /**
     * AlbumClass@1234{size:size(),classId:''}
     */
    @Override
    public String toString() {
        return "AlbumClass@" + userId + "{size:" + imageClassList.size() + ",classId:" + imageClassId + "}";
    }
}
