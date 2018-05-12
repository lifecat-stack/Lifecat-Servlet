package com.wang.form;

import com.wang.bean.BeanBuilder;


/**
 * FormResult: 返回Form验证结果对象
 * <p>
 * 访问范围: 构造器包访问,getter全局
 * 应用模式: 构造器模式
 * 不可变对象
 *
 * @auther ten
 */
public class FormResult {

    private final boolean error;
    private final String errormsg;

    private FormResult(Builder builder) {
        this.error = builder.error;
        this.errormsg = builder.errormsg;
    }

    /**
     * Builder: FormResult构建器
     *
     * @auther ten
     */
    protected static class Builder implements BeanBuilder<FormResult> {

        private final boolean error;

        private String errormsg = "null";

        public Builder(boolean error) {
            this.error = error;
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

    //FormResult@{error:true,errormsg:'null'}
    @Override
    public String toString() {
        return "FormResult@{error:" + error + ",errormsg:" + errormsg + "}";
    }

    //getter
    public boolean error() {
        return error;
    }

    public String getErrormsg() {
        return errormsg;
    }
}
