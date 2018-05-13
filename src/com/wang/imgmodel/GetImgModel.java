package com.wang.imgmodel;

import com.wang.bean.Image;
import com.wang.domodel.ModelResult;
import com.wang.domodel.MyModel;
import com.wang.util.HOST;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * {@literal 获取ArrayList<Image>}
 *
 * @auther ten
 */
class GetImgModel implements MyModel {
        private GetImgModel() {
    }

    static MyModel getModel() {
        return new GetImgModel();
    }

    @Override
    public ModelResult execute(HttpServletRequest req, HttpServletResponse resp) {
        return null;
    }

    /**
     * 根据userid获取对应目录下的所有图片:
     * <p>
     * 1. 生成目录路径
     * 2. 打开目录
     * 3. 目录存在 ? 读取 : 抛出NullPointerException
     * 4. 返回所有图片Image的集合
     *
     * @param userid 用户id
     * @return {@literal List<Image> 使用接口作为引用}
     * @throws NullPointerException  此ID文件目录不存在
     * @throws IllegalStateException 目录下为空
     */
    public static List<Image> getImagesById(int userid) {
        String image_path = HOST.IMAGE_PATH + userid;

        File directory = new File(image_path);

        List<Image> paths = new ArrayList<>();

        if (directory.exists()) {

            File[] files = directory.listFiles();

            //目录下文件为空
            if (files == null) {
                throw new IllegalStateException("Directory is null");
            }

            //遍历生成Image
            for (File file : files) {
                Image image = new Image.Builder(HOST.HOST_IMAGE_PATH + file.getName())
                        .image_date(file.getName()).build();
                paths.add(image);
            }
        }
        //目录不存在
        else {
            throw new NullPointerException("Directory is not existed");
        }

        return paths;
    }

    /**
     * @name 获取部分图片链接
     * @description homePage.jsp-->获取demo图片路径
     */
    public static String[] getDemoImages() {
        //获取全部路径
        String[] paths = getImagesById();
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
        File directory = new File(HOST.CATEGORY_IMAGE_PATH + num + "/");
        //获取目录下所有文件
        File[] files = directory.listFiles();
        //绝对路径数组
        String[] paths = new String[files.length];

        for (int i = 0; i < files.length; i++) {
            paths[i] = HOST.HOST_CATEGORY_IMAGE_PATH + num + "/" + files[i].getName();
        }

        return paths;
    }
}
