package com.wang.bean;

import com.wang.util.MyBuilder;

/**
 * Diary: diary存储图片表
 * <p>
 * 访问范围: 全局
 * 实现接口: Bean, Comparable
 * 获取实例: 构建器
 *
 * @auther ten
 */
public class Diary implements Bean, Comparable<Diary> {
    /**
     * diary_id: 主键
     * diary_name: diaryname
     * diary_date: diary上传日期
     * diary_desc: diary内容
     */
    private final int diary_id;
    private final String diary_name;
    private final String diary_date;
    private final String diary_desc;

    //hashcode:缓存
    private volatile int hashCode;

    private Diary(Diary.Builder builder) {
        if (builder.diary_id == 0) {
            diary_id = hashCode();
        } else {
            diary_id = builder.diary_id;
        }
        diary_name = builder.diary_name;
        diary_date = builder.diary_date;
        diary_desc = builder.diary_desc;
    }

    /**
     * diary构建器:
     * <p>
     * diary_name:
     * diary_type: enum
     * image_date:
     *
     * @auther ten
     */
    public static class Builder implements MyBuilder<Diary> {

        private int diary_id = 0;
        private String diary_date = "2000-0-0-0-0-0";
        private String diary_name = "diary";
        private String diary_desc = "这是一篇diary";

        public Builder() {

        }

        public Builder diary_id(int val) {
            diary_id = val;
            return this;
        }

        public Builder diary_date(String val) {
            diary_date = val;
            return this;
        }


        public Builder diary_name(String val) {
            diary_name = val;
            return this;
        }

        public Builder diary_desc(String val) {
            diary_desc = val;
            return this;
        }

        @Override
        public Diary build() {
            return new Diary(this);
        }
    }


    /**
     * compareTo: Comparable
     * <p>
     * 根据diary_date进行比较
     * <p>
     * 1. 小于 负数
     * 2. 等于 零
     * 3. 大于 正数
     *
     * @param diary diary
     * @return this-other ? 负 : (this-other ? 0 : 正)
     */
    @Override
    public int compareTo(Diary diary) {
        return Integer.valueOf(this.diary_date) - Integer.valueOf(diary.diary_date);
    }

    /**
     * equals: 判断Diary是否相等
     * 1. 引用检测
     * 1. 类型检测
     * <p>
     * 2. Diary_id
     * 3. Diary_name
     * 4. Diary_date
     * 5. Diary_desc
     *
     * @param obj Object
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Diary)) {
            return false;
        }
        if (this.diary_id != ((Diary) obj).diary_id) {
            return false;
        }
        if (!this.diary_name.equals(((Diary) obj).diary_name)) {
            return false;
        }
        if (!this.diary_date.equals(((Diary) obj).diary_date)) {
            return false;
        }
        if (!this.diary_desc.equals(((Diary) obj).diary_desc)) {
            return false;
        }
        return true;
    }

    /**
     * hashCode: 计算Diary_id
     * <p>
     * 1. name
     * 2. date
     * 3. desc
     *
     * @return Diary_id
     */
    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = 17;
            result = 31 * result + diary_name.hashCode();
            result = 31 * result + diary_date.hashCode();
            result = 31 * result + diary_desc.hashCode();
            hashCode = result;
        }
        return result;
    }

    //Diary@1234{name:'',date:'',desc:''}
    @Override
    public String toString() {
        return "Diary@" + getDiary_id() + "{name:" + diary_name + ",date:"
                + diary_date + ",desc:" + diary_desc + "}";
    }

    //getter
    public int getDiary_id() {
        return diary_id;
    }

    public String getDiary_name() {
        return diary_name;
    }

    public String getDiary_date() {
        return diary_date;
    }

    public String getDiary_desc() {
        return diary_desc;
    }
}
