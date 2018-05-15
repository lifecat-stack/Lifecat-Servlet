package com.wang.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Album: Image集
 * <p>
 * 访问范围: 全局
 * 获取实例: 静态工厂
 *
 * @auther ten
 */
public class Album {

    private final int user_id;
    private final List<Image> images;

    private Album(int user_id) {
        this.user_id = user_id;
        images = new ArrayList<>();
    }

    public static Album newAlbum(int user_id) {
        return new Album(user_id);
    }

    /**
     * 向List添加Image对象
     *
     * @param image Image对象
     */
    public void addImage(Image image) {
        images.add(image);
    }

    /**
     * {@literal 获取List<Image>}
     *
     * @return {@literal List<Image>}
     */
    public List<Image> getImages() {
        return this.images;
    }

    //Album@1234{size()}
    @Override
    public String toString() {
        return "Album@" + user_id + "{" + images.size() + "}";
    }
}
