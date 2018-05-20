package com.wang.dto;

import com.wang.util.MyBuilder;

/**
 * DTO :Image图片对象
 * <p>
 * 构建了可变属性集，默认{类型:0,文本:成长记录}
 * 实现comparable接口，可根据上传日期date进行排序
 * 覆盖equals() hashCode()
 *
 * @auther ten
 */
public class ImageDTO implements Comparable<ImageDTO> {

    private final int imageId;
    private final String imageText;
    private final String imagePath;
    private final String imageDate;
    private final int imageType;

    /**
     * hashCode缓存
     */
    private volatile int hashCode;

    private ImageDTO(ImageDTO.Builder builder) {
        imageId = builder.imageId;
        imageText = builder.imageText;
        imagePath = builder.imagePath;
        imageDate = builder.imageDate;
        imageType = builder.imageType;
    }

    public static class Builder implements MyBuilder<ImageDTO> {

        private final int imageId;
        private final String imagePath;
        private final String imageDate;

        //默认类别{0:未分类}
        private int imageType = 0;
        //默认文本:"成长记录"
        private String imageText = "成长记录";

        public Builder(int imageId, String imagePath, String imageDate) {
            this.imageId = imageId;
            this.imagePath = imagePath;
            this.imageDate = imageDate;
        }

        public Builder imageText(String val) {
            imageText = val;
            return this;
        }

        public Builder imageType(int val) {
            imageType = val;
            return this;
        }

        @Override
        public ImageDTO build() {
            return new ImageDTO(this);
        }
    }

    /**
     * compareTo: Comparable
     * <p>
     * 根据ImageDate进行比较
     * <p>
     * 1. 小于 负数
     * 2. 等于 零
     * 3. 大于 正数
     *
     * @param img Image
     * @return this-other ? 负 : (this-other ? 0 : 正)
     */
    @Override
    public int compareTo(ImageDTO img) {
        return Integer.valueOf(this.imageDate) - Integer.valueOf(img.getImageDate());
    }

    //忽略imageType
    @Override
    public boolean equals(Object obj) {
        //引用检测
        if (obj == this) {
            return true;
        }
        //类型检测
        if (!(obj instanceof ImageDTO)) {
            return false;
        }
        //参数检测
        if (this.imageId != ((ImageDTO) obj).getImageId()) {
            return false;
        }
        if (!this.imageDate.equals(((ImageDTO) obj).getImageDate())) {
            return false;
        }
        if (!this.imagePath.equals(((ImageDTO) obj).getImagePath())) {
            return false;
        }
        if (!this.imageText.equals(((ImageDTO) obj).getImageText())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = 17 ;
            result = 31 * result + imageId;
            result = 31 * result + imageDate.hashCode();
            result = 31 * result + imagePath.hashCode();
            result = 31 * result + imageText.hashCode();
            result = 31 * result + imageType;
            hashCode = result;
        }
        return result;
    }

    //Image@1234{text:'',date:'',path:'',type:''}
    @Override
    public String toString() {
        return "Image@" + imageId + "{text:" + imageText + ",date:" + imageDate +
                ",path:" + imagePath + ",type:" + imageType + "}";
    }

    //getter
    public int getImageId() {
        return imageId;
    }

    public String getImageText() {
        return imageText;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getImageDate() {
        return imageDate;
    }

    public int getImageType() {
        return imageType;
    }

    public int getHashCode() {
        return hashCode;
    }

}
