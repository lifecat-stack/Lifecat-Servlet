package com.ten.bean.vo;

/**
 * DTO :Admin管理员账号
 * <p>
 * 覆盖equals() hashCode()
 *
 * @auther ten
 */
public class AdminVO {

    private Integer adminId;
    private String adminName;
    private String adminLevel;

    /**
     * hashCode缓存
     */
    private volatile int hashCode;

    public AdminVO(Integer adminId, String adminName, String adminLevel) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminLevel = adminLevel;
    }

    @Override
    public boolean equals(Object obj) {
        //引用检测
        if (obj == this) {
            return true;
        }
        //类型检测
        if (!(obj instanceof AdminVO)) {
            return false;
        }
        //参数检测
        if (!this.adminId.equals(((AdminVO) obj).getAdminId())) {
            return false;
        }
        if (!this.adminName.equals(((AdminVO) obj).getAdminName())) {
            return false;
        }
        if (!this.adminLevel.equals(((AdminVO) obj).getAdminLevel())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = 17;
            result = 31 * result + adminId;
            result = 31 * result + adminName.hashCode();
            result = 31 * result + adminLevel.hashCode();
            hashCode = result;
        }
        return result;
    }

    /**
     * Admin@1234{name:wang,level:LEVEL}
     */
    @Override
    public String toString() {
        return "Admin@" + adminId + "{name:" + adminName + ",level:" + adminLevel + "}";
    }

    /**
     * getter方法
     */
    public Integer getAdminId() {
        return adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public String getAdminLevel() {
        return adminLevel;
    }
}
