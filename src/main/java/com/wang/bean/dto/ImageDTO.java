package com.wang.bean.dto;

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

    private Integer imageId;
    private String imageText;
    private String imagePath;
    private String imageDate;
    private Integer imageClassId;

    /**
     * hashCode缓存
     */
    private volatile int hashCode;

    public ImageDTO(Integer imageId) {
        this.imageId = imageId;
    }

    public ImageDTO imageText(String imageText) {
        this.imageText = imageText;
        return this;
    }

    public ImageDTO imagePath(String imagePath) {
        this.imagePath = imagePath;
        return this;
    }

    public ImageDTO imageDate(String imageDate) {
        this.imageDate = imageDate;
        return this;
    }

    public ImageDTO imageClassId(Integer imageClassId) {
        this.imageClassId = imageClassId;
        return this;
    }

    /**
     * compareTo: Comparable
     * <p>
     * 根据ImageDate进行比较
     * <p>
     * 时间最近的更大
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
        String date1 = this.imageDate;
        String date2 = img.imageDate;
        for (int i = 0; i < date1.length(); i++) {
            if (date1.charAt(i) > date2.charAt(i)) {
                return 1;
            } else if (date1.charAt(i) < date2.charAt(i)) {
                return -1;
            }
        }
        return 0;
    }

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
        if (!this.imageId.equals(((ImageDTO) obj).getImageId())) {
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
            result = 17;
            result = 31 * result + imageId;
            result = 31 * result + imageDate.hashCode();
            result = 31 * result + imagePath.hashCode();
            result = 31 * result + imageText.hashCode();
            result = 31 * result + imageClassId;
            hashCode = result;
        }
        return result;
    }

    /**
     * Image@1234{text:'',date:'',path:'',class:''}
     */
    @Override
    public String toString() {
        return "Image@" + imageId + "{text:" + imageText + ",date:" + imageDate +
                ",path:" + imagePath + ",class:" + imageClassId + "}";
    }

    /**
     * getter
     */
    public Integer getImageId() {
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

    public Integer getImageClassId() {
        return imageClassId;
    }

    public int getHashCode() {
        return hashCode;
    }
}
