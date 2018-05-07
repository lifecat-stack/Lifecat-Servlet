package com.wang.model;

import com.wang.util.HOST;

import java.io.*;
import java.util.Arrays;

/**
 * @name GetImgModel
 * @description 获取upimage文件夹下的所有图片路径
 * @auther ten
 */
public class GetImgModel implements HOST {
    /**
     * @name 获取图片链接
     * @description imageshow.jsp-->获取所有图片的路径
     */
    public static String[] getImages() {
        //获取图片目录
        File directory = new File(image_path);
        //获取目录下所有文件
        File[] files = directory.listFiles();
        //绝对路径数组
        String[] paths = new String[files.length];

        for (int i = 0; i < files.length; i++) {
            paths[i] = host_image_path + files[i].getName();
        }

        return paths;
    }

    /**
     * @name 获取部分图片链接
     * @description homePage.jsp-->获取demo图片路径
     */
    public static String[] getDemoImages() {
        //获取全部路径
        String[] paths = getImages();
        //截取部分路径
        String[] demo_paths = Arrays.copyOfRange(paths, paths.length - 8, paths.length);

        return demo_paths;
    }

    /**
     * @name 获取分类的某类图片
     * @description 从本地路径读取目录，然后返回服务器路径
     */
    public static String[] getCategoryImages(int num) {
        //获取图片目录
        File directory = new File(category_image_path + num + "/");
        //获取目录下所有文件
        File[] files = directory.listFiles();
        //绝对路径数组
        String[] paths = new String[files.length];

        for (int i = 0; i < files.length; i++) {
            paths[i] = host_category_image_path + num + "/" + files[i].getName();
        }

        return paths;
    }
}
