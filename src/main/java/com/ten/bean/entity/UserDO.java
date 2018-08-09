package com.ten.bean.entity;

/**
 * DO :user
 *
 * @auther ten
 */
public class UserDO {

    private Integer userId;
    private String userName;
    private String userPassword;
    private String userLevel;
    private String userGmtCreate;
    private String userGmtModified;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public String getUserGmtCreate() {
        return userGmtCreate;
    }

    public void setUserGmtCreate(String userGmtCreate) {
        this.userGmtCreate = userGmtCreate;
    }

    public String getUserGmtModified() {
        return userGmtModified;
    }

    public void setUserGmtModified(String userGmtModified) {
        this.userGmtModified = userGmtModified;
    }

    /**
     * @return UserDO@1234{ID:'',Name:'',Password:'',Level:'',Create:'',Modified:''}
     */
    @Override
    public String toString() {
        return "UserDO@" + userId
                + "{ID:" + userId
                + ",Name:" + userName
                + ",Password:" + userPassword
                + ",Level:" + userLevel
                + ",Create:" + userGmtCreate
                + ",Modified:" + userGmtModified
                + "}";
    }
}
