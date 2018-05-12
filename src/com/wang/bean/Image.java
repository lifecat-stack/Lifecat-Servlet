package com.wang.bean;

/**
 * Image: image存储图片表
 * <p>
 * 访问范围: 全局
 * 实现Comparable接口
 *
 * @auther ten
 */
public class Image implements Bean, Comparable<Image> {
    /**
     * 不可变对象
     * image_id: 主键
     * image_name: image
     * image_desc: image描述
     * image_date: iamge上传日期
     * image_path: 在服务器上的存储路径
     */
    private final int image_id;
    private final String image_name;
    private final String image_desc;
    private final String image_date;
    private final String image_path;

    //hashcode:缓存
    private volatile int hashCode;

    private Image(Image.Builder builder) {
        //hashCode()生成id
        image_id = hashCode();

        image_name = builder.image_name;
        image_desc = builder.image_desc;
        image_date = builder.image_date;
        image_path = builder.image_path;
    }

    /**
     * image构建器:
     * <p>
     * image_path:url
     * <p>
     * image_name:
     * image_desc:
     * image_date:
     *
     * @auther ten
     */
    public static class Builder implements BeanBuilder<Image> {

        private final String image_path;

        private String image_name = "default_name";
        private String image_desc = "default_desc";
        private String image_date = "default_date";

        public Builder(String image_path) {
            this.image_path = image_path;
        }

        public Builder image_name(String val) {
            image_name = val;
            return this;
        }

        public Builder image_desc(String val) {
            image_desc = val;
            return this;
        }

        public Builder image_date(String val) {
            image_date = val;
            return this;
        }

        @Override
        public Image build() {
            return new Image(this);
        }
    }


    /**
     * compareTo: Comparable
     * <p>
     * 根据Image_date进行比较
     * <p>
     * 1. 小于 负数
     * 2. 等于 零
     * 3. 大于 正数
     *
     * @param img Image
     * @return this-other ? 负 : (this-other ? 0 : 正)
     */
    @Override
    public int compareTo(Image img) {
        return Integer.valueOf(this.image_date) - Integer.valueOf(img.image_date);
    }

    /**
     * equals: 判断Image是否相等
     * 1. 引用检测
     * 1. 类型检测
     * <p>
     * 2. Image_id
     * 3. Image_path
     * 4. Image_date
     * 5. Image_name
     *
     * @param obj Object
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Image)) {
            return false;
        }
        if (this.image_id != ((Image) obj).image_id) {
            return false;
        }
        if (!this.image_path.equals(((Image) obj).image_path)) {
            return false;
        }
        if (!this.image_date.equals(((Image) obj).image_date)) {
            return false;
        }
        if (!this.image_name.equals(((Image) obj).image_name)) {
            return false;
        }
        return true;
    }

    /**
     * hashCode: 计算Image_id
     * <p>
     * 1. path
     * 2. date
     * 3. desc
     * 4. name
     *
     * @return image_id
     */
    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = 19;
            result = 31 * result + image_path.hashCode();
            result = 31 * result + image_date.hashCode();
            result = 31 * result + image_desc.hashCode();
            result = 31 * result + image_name.hashCode();
            hashCode = result;
        }
        return result;
    }

    //Image@1234{name:'',desc:'',date:'',path:''}
    @Override
    public String toString() {
        return "Image@" + image_id + "{name:" + image_name + ",desc:"
                + image_desc + ",date:" + image_date + ",path:" + image_path + "}";
    }

    //getter
    public int getImage_id() {
        return image_id;
    }

    public String getImage_name() {
        return image_name;
    }

    public String getImage_desc() {
        return image_desc;
    }

    public String getImage_date() {
        return image_date;
    }

    public String getImage_path() {
        return image_path;
    }
}
