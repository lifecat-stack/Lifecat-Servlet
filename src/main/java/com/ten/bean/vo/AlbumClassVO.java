package com.ten.bean.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO :Album分类集合，不同类别图片集合
 *
 * @auther ten
 */
public class AlbumClassVO {

    private final List<ImageVO> imageClassList;
    private final Integer userId;
    private final Integer imageClassId;

    public AlbumClassVO(int userId, int imageClassId) {
        this.userId = userId;
        this.imageClassId = imageClassId;
        imageClassList = new ArrayList<>();
    }

    /**
     * 向List添加ImageDTO对象
     *
     * @param image ImageDTO对象
     */
    public void addImage(ImageVO image) {
        imageClassList.add(image);
    }

    /**
     * {@literal 获取List<ImageVO>}
     *
     * @return {@literal List<ImageVO>}
     */
    public List<ImageVO> getImageClassList() {
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
