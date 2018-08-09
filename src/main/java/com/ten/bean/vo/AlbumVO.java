package com.ten.bean.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO :Album集合，用户图片集
 *
 * @auther ten
 */
public class AlbumVO {

    private final List<ImageVO> imageList;
    private final Integer userId;

    private AlbumVO(int userId) {
        this.userId = userId;
        imageList = new ArrayList<>();
    }

    public static AlbumVO newAlbum(int userId) {
        return new AlbumVO(userId);
    }

    /**
     * 向List添加ImageDTO对象
     *
     * @param image ImageDTO对象
     */
    public void addImage(ImageVO image) {
        imageList.add(image);
    }

    /**
     * {@literal 获取List<ImageVO>}
     *
     * @return {@literal List<ImageVO>}
     */
    public List<ImageVO> getImageList() {
        return this.imageList;
    }

    /**
     * Album@1234{size:size()}
     */
    @Override
    public String toString() {
        return "Album@" + userId + "{size:" + imageList.size() + "}";
    }
}
