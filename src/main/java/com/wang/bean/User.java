package com.wang.bean;

import com.wang.util.MyBuilder;

/**
 * User: user表用户账户信息
 * <p>
 * id: 主键
 * name: 用户名
 * password: 密码
 * level: 访问权限
 *
 * @auther ten
 */
public class User implements Bean {

    private final int id;
    private final String name;
    private final String password;
    private final String level;

    private volatile int hashCode;

    private User(Builder builder) {
        if (builder.id == 0) {
            id = hashCode();
        } else {
            id = builder.id;
        }
        name = builder.name;
        password = builder.password;
        level = builder.level;
    }

    /**
     * user构建器
     * <p>
     * name: 用户名
     * password: 密码
     * <p>
     * id: hashCode()
     * level: user等级
     *
     * @auther ten
     */
    public static class Builder implements MyBuilder<User> {

        private final String name;
        private final String password;

        private int id = 0;
        private String level = "user";

        public Builder(String name, String password) {
            this.name = name;
            this.password = password;
        }

        public Builder id(int val) {
            id = val;
            return this;
        }

        public Builder level(String val) {
            level = val;
            return this;
        }

        @Override
        public User build() {
            return new User(this);
        }
    }

    /**
     * equals: 判断User是否相等
     * 1. 引用检测
     * 1. 类型检测
     * <p>
     * 2. id
     * 3. name
     * 4. password
     * 5. level
     *
     * @param obj Object
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        if (this.id != ((User) obj).id) {
            return false;
        }
        if (!this.name.equals(((User) obj).name)) {
            return false;
        }
        if (!this.password.equals(((User) obj).password)) {
            return false;
        }
        if (!this.level.equals(((User) obj).level)) {
            return false;
        }
        return true;
    }

    /**
     * hashCode: 计算user_id
     * <p>
     * 1. name
     * 2. password
     * 3. level
     *
     * @return image_id
     */
    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = 17;
            result = 31 * result + name.hashCode();
            result = 31 * result + password.hashCode();
            result = 31 * result + level.hashCode();
            hashCode = result;
        }
        return result;
    }

    //User@1234{wang:123456,LEVEL}
    @Override
    public String toString() {
        return "User@" + id + "{" + name + ":" + password + "," + level + "}";
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
        return String.valueOf(level);
    }
}