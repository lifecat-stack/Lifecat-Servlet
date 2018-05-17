package com.wang.dto;

import com.wang.util.MyBuilder;

/**
 * DTO :Admin管理员账号
 * <p>
 * 覆盖equals() hashCode()
 *
 * @auther ten
 */
public class AdminDTO {

    private final int adminId;
    private final String adminName;
    private final String adminLevel;

    /**
     * hashCode缓存
     */
    private volatile int hashCode;

    private AdminDTO(AdminDTO.Builder builder) {
        adminId = builder.adminId;
        adminName = builder.adminName;
        adminLevel = builder.adminLevel;
    }

    public static class Builder implements MyBuilder<AdminDTO> {

        private final int adminId;
        private final String adminName;
        private final String adminLevel;

        public Builder(int admin_id, String admin_name, String admin_level) {
            this.adminId = admin_id;
            this.adminName = admin_name;
            this.adminLevel = admin_level;
        }

        @Override
        public AdminDTO build() {
            return new AdminDTO(this);
        }
    }

    @Override
    public boolean equals(Object obj) {
        //引用检测
        if (obj == this) {
            return true;
        }
        //类型检测
        if (!(obj instanceof AdminDTO)) {
            return false;
        }
        //参数检测
        if (this.adminId != ((AdminDTO) obj).getAdminId()) {
            return false;
        }
        if (!this.adminName.equals(((AdminDTO) obj).getAdminName())) {
            return false;
        }
        if (!this.adminLevel.equals(((AdminDTO) obj).getAdminLevel())) {
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

    //Admin@1234{wang,LEVEL}
    @Override
    public String toString() {
        return "Admin@" + adminId + "{" + adminName + "," + adminLevel + "}";
    }

    //getter方法
    public int getAdminId() {
        return adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public String getAdminLevel() {
        return adminLevel;
    }
}
