package com.wang.bean;

import com.wang.util.MyBuilder;

/**
 * usermsg表: 用户资料
 * <p>
 * user_id: 外键
 * nickname: 昵称
 * sex: 性别
 * age: 年龄
 * birthday: 生日
 * email: 邮箱
 * iconpath: 用户头像图片路径
 *
 * @auther ten
 */
public class UserMsg implements Bean {

    private final int user_id;
    private final String nickname;
    private final String sex;
    private final String age;
    private final String birthday;
    private final String email;
    private final String iconpath;

    /**
     * usermsg构建器
     *
     * @auther
     */
    public static class Builder implements MyBuilder<UserMsg> {

        private final int id;

        private String nickname = "wang";
        private String sex = "男";
        private String age = "21";
        private String birthday = "1997";
        private String email = "@qq.com";
        private String iconpath = "image/icon.jpg";

        public Builder(int id) {
            this.id = id;
        }

        public UserMsg.Builder nickname(String val) {
            nickname = val;
            return this;
        }

        public UserMsg.Builder sex(String val) {
            sex = val;
            return this;
        }

        public UserMsg.Builder age(String val) {
            age = val;
            return this;
        }

        public UserMsg.Builder birthday(String val) {
            birthday = val;
            return this;
        }

        public UserMsg.Builder email(String val) {
            email = val;
            return this;
        }

        public UserMsg.Builder iconpath(String val) {
            iconpath = val;
            return this;
        }

        //build
        @Override
        public UserMsg build() {
            return new UserMsg(this);
        }
    }

    //私有构造器
    private UserMsg(UserMsg.Builder builder) {
        user_id = builder.id;
        nickname = builder.nickname;
        age = builder.age;
        sex = builder.sex;
        birthday = builder.birthday;
        email = builder.email;
        iconpath = builder.iconpath;
    }

    //UserMsg@1234{nickname:'',sex:'',age:'',birthday:'',email:'',iconpath:''}
    @Override
    public String toString() {
        return "UserMsg@" + user_id + "{"
                + "nickname:" + nickname + ","
                + "sex" + sex + ","
                + "age" + age + ","
                + "birthday" + birthday + ","
                + "email" + email + ","
                + "iconpath" + iconpath + "}";
    }

    //getter
    public int getUser_id() {
        return user_id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getSex() {
        return sex;
    }

    public String getAge() {
        return age;
    }

    public String getBirthday() {
         return birthday;
    }

    public String getEmail() {
        return email;
    }

    public String getIconPath() {
        return iconpath;
    }

}
