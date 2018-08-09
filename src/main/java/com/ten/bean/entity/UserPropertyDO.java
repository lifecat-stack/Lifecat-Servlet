package com.ten.bean.entity;

/**
 * DO :user_property
 *
 * @auther ten
 */
public class UserPropertyDO {

    private Integer userId;
    private String propertyNickname;
    private String propertySignature;
    private String propertySex;
    private String propertyEmail;
    private String propertyLocation;
    private String propertyBirthday;
    private String propertyGmtCreate;
    private String propertyGmtModified;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPropertyNickname() {
        return propertyNickname;
    }

    public void setPropertyNickname(String propertyNickname) {
        this.propertyNickname = propertyNickname;
    }

    public String getPropertySignature() {
        return propertySignature;
    }

    public void setPropertySignature(String propertySignature) {
        this.propertySignature = propertySignature;
    }

    public String getPropertySex() {
        return propertySex;
    }

    public void setPropertySex(String propertySex) {
        this.propertySex = propertySex;
    }
    public String getPropertyEmail() {
        return propertyEmail;
    }

    public void setPropertyEmail(String propertyEmail) {
        this.propertyEmail = propertyEmail;
    }

    public String getPropertyLocation() {
        return propertyLocation;
    }

    public void setPropertyLocation(String propertyLocation) {
        this.propertyLocation = propertyLocation;
    }

    public String getPropertyBirthday() {
        return propertyBirthday;
    }

    public void setPropertyBirthday(String propertyBirthday) {
        this.propertyBirthday = propertyBirthday;
    }

    public String getPropertyGmtCreate() {
        return propertyGmtCreate;
    }

    public void setPropertyGmtCreate(String propertyGmtCreate) {
        this.propertyGmtCreate = propertyGmtCreate;
    }

    public String getPropertyGmtModified() {
        return propertyGmtModified;
    }

    public void setPropertyGmtModified(String propertyGmtModified) {
        this.propertyGmtModified = propertyGmtModified;
    }

    /**
     * @return UserPropertyDO@1234{UserID:'',Nickname:'',Signature:'',Sex:'',Email:'',Location:'',Birthday :'',Create:'',Modified:''}
     */
    @Override
    public String toString() {
        return "UserDO@" + userId
                + "{UserID:" + userId
                + ",Nickname:" + propertyNickname
                + ",Signature:" + propertySignature
                + ",Sex:" + propertySex
                + ",Email:" + propertyEmail
                + ",Location:" + propertyLocation
                + ",Birthday:" + propertyBirthday
                + ",Create:" + propertyGmtCreate
                + ",Modified:" + propertyGmtModified
                + "}";
    }
}
