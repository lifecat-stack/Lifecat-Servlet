package com.wang.bean.dto;

import java.util.ArrayList;
import java.util.List;
/**
 * DTO :Album分类集合，不同类别图片集合
 *
 * @auther ten
 */
public class AlbumClassDTO {
    /**
     * List 引用不可变，值可变
     */
    private final List<ImageDTO> imageClassList;
    private final int userId;
    private final int imageClass;

    private AlbumClassDTO(int userId, int imageClass) {
        this.userId = userId;
        this.imageClass = imageClass;
        imageClassList = new ArrayList<>();
    }

    public static AlbumClassDTO newAlbumClass(int userId, int imageClass) {
        return new AlbumClassDTO(userId, imageClass);
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

    //AlbumClass@1234{size:size(),class:''}
    @Override
    public String toString() {
        return "AlbumClass@" + userId + "{size:" + imageClassList.size() + ",class:" + imageClass + "}";
    }
}
