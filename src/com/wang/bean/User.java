package com.wang.bean;

/**
 * @name User
 * @description User用户登录信息数据库
 * @auther ten
 */
public class User implements Bean {

    //数据表属性
    private final int id;
    private final String name;
    private final String password;
    private final String level;

    //hashcode:若无则生成，若存在则直接调用
    private volatile int hashCode;


    /**
     * @name Builder
     * @description User构建器
     * @auther
     */
    public static class Builder implements BeanBuilder<User> {
        //必要参数
        private final String name;
        private final String password;

        //默认参数
        private String level = "user";

        //构造器
        public Builder(String name, String password) {
            this.name = name;
            this.password = password;
        }

        //设置可选参数
        public Builder level(String val) {
            level = val;
            return this;
        }

        //build
        @Override
        public User build() {
            return new User(this);
        }
    }

    //私有构造器
    private User(Builder builder) {
        //id不能由外部设置，由hashCode()计算
        id = hashCode();

        name = builder.name;
        password = builder.password;
        level = builder.level;
    }

    //UserHash
    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = 17;
            result = 31 * result + name.hashCode();
            result = 31 * result + password.hashCode();
            hashCode = result;
        }
        return result;
    }

    //对象描述 User@1234{wang:123456}
    @Override
    public String toString() {
        return "User@" + id + "{" + name + ":" + password + "}";
    }

    //getter方法
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getLevel() {
        return level;
    }
}