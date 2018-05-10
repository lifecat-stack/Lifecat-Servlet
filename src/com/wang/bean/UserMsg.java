package com.wang.bean;

/**
 * @name UserMsg
 * @description UserMsg用户个人信息
 * @auther ten
 */
public class UserMsg implements Bean {
    //根据id插入对应user数值
    private int id;

    private String nickname;
    private String sex;
    private String age;
    private String birthday;
    private String email;

    /**
     * @name Builder
     * @description UserMsg构建器
     * @auther
     */
    public static class Builder implements BeanBuilder<UserMsg> {
        //必要参数
        private int id;

        //默认参数
        private String nickname = "nickname";
        private String sex = "sex";
        private String age = "age";
        private String birthday = "birthday";
        private String email = "email";

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

        //build
        @Override
        public UserMsg build() {
            return new UserMsg(this);
        }
    }

    //私有构造器
    private UserMsg(UserMsg.Builder builder) {
        id = builder.id;
        nickname = builder.nickname;
        age = builder.age;
        sex = builder.sex;
        birthday = builder.birthday;
        email = builder.email;
    }

    //对象描述 UserMsg@1234{nickname:'',sex:'',age:'',birthday:'',email:''}
    @Override
    public String toString() {
        return "UserMsg@" + id + "{"
                + "nickname:" + nickname + ","
                + "sex" + sex + ","
                + "age" + age + ","
                + "birthday" + birthday + ","
                + "email" + email + "}";
    }

    //getter
    public int getId() {
        return id;
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
}
