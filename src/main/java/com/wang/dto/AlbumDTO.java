package com.wang.dto;

import java.util.ArrayList;
import java.util.List;
/**
 * DTO :Album集合，用户图片集
 *
 * @auther ten
 */
public class AlbumDTO {
    /**
     * List 引用不可变，值可变
     */
    private final List<ImageDTO> imageList;
    private final int userId;

    private AlbumDTO(int userId) {
        this.userId = userId;
        imageList = new ArrayList<>();
    }

    public static AlbumDTO newAlbum(int userId) {
        return new AlbumDTO(userId);
    }

    /**
     * 向List添加ImageDTO对象
     *
     * @param image ImageDTO对象
     */
    public void addImage(ImageDTO image) {
        imageList.add(image);
    }

    /**
     * {@literal 获取List<ImageDTO>}
     *
     * @return {@literal List<ImageDTO>}
     */
    public List<ImageDTO> getImageList() {
        return this.imageList;
    }

    //Album@1234{size:size()}
    @Override
    public String toString() {
        return "Album@" + userId + "{size:" + imageList.size() + "}";
    }
}
