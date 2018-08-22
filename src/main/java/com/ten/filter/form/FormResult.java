package com.ten.filter.form;

import com.ten.bean.MyBuilder;


/**
 * FormResult: 返回Form验证Result对象
 * <p>
 * 访问范围: 构造器包访问,getter全局
 * 获取实例: 构建器
 *
 * @auther ten
 */
public class FormResult {

    private final boolean success;
    private final String errormsg;

    private FormResult(Builder builder) {
        this.success = builder.success;
        this.errormsg = builder.errormsg;
    }

    /**
     * Builder: FormResult构建器
     *
     * @auther ten
     */
    public  static class Builder implements MyBuilder<FormResult> {

        private final boolean success;

        private String errormsg = "null";

        public Builder(boolean success) {
            this.success = success;
        }

        public Builder errormsg(String errormsg) {
            this.errormsg = errormsg;
            return this;
        }

        @Override
        public FormResult build() {
            return new FormResult(this);
        }
    }

    /**
     * FormResult@{success:true,errormsg:'null'}
     */
    @Override
    public String toString() {
        return "FormResult@{success:" + success + ",errormsg:" + errormsg + "}";
    }

    //getter
    public boolean isSuccess() {
        return success;
    }

    public String getErrormsg() {
        return errormsg;
    }
}
