package com.wang.bean;

/**
 * usermsg表: 用户资料
 * <p>
 * user_id: 外键
 * nickname: 昵称
 * sex: 性别
 * age: 年龄
 * birthday: 生日
 * email: 邮箱
 * icon: 用户头像图片路径
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
    private final String icon;

    /**
     * usermsg构建器
     *
     * @auther
     */
    public static class Builder implements BeanBuilder<UserMsg> {
        //必要参数
        private final int id;

        //默认参数
        private String nickname = "default_nickname";
        private String sex = "default_sex";
        private String age = "default_age";
        private String birthday = "default_birthday";
        private String email = "default_email";
        private String icon = "default_icon";

        //构造器
        public Builder(int id) {
            this.id = id;
        }

        //设置可选参数
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

        public UserMsg.Builder icon(String val) {
            icon = val;
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
        icon = builder.icon;
    }

    //对象描述 UserMsg@1234{nickname:'',sex:'',age:'',birthday:'',email:'',icon:''}
    @Override
    public String toString() {
        return "UserMsg@" + user_id + "{"
                + "nickname:" + nickname + ","
                + "sex" + sex + ","
                + "age" + age + ","
                + "birthday" + birthday + ","
                + "email" + email + ","
                + "icon" + icon + "}";
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

    public String getIcon() {
        return icon;
    }

}
