package com.ten.service.impl;

import com.ten.bean.MyBuilder;
import com.ten.constant.Page;

/**
 * ServiceResult: 返回Service执行结果对象
 *
 * @auther ten
 */
public class ServiceResult {

    private final boolean success;
    private final String page;
    private final String errormsg;

    private ServiceResult(Builder builder) {
        this.success = builder.success;
        this.page = builder.page;
        this.errormsg = builder.errormsg;
    }

    /**
     * Builder: ModelResult构建器
     *
     * @auther ten
     */
    protected static class Builder implements MyBuilder<ServiceResult> {

        private final boolean success;

        private String errormsg = "null";
        private String page = Page.PAGE_INDEX;

        protected Builder(boolean success) {
            this.success = success;
        }

        protected ServiceResult.Builder errormsg(String errormsg) {
            this.errormsg = errormsg;
            return this;
        }

        protected ServiceResult.Builder page(String page) {
            this.page = page;
            return this;
        }

        @Override
        public ServiceResult build() {
            return new ServiceResult(this);
        }
    }

    // ServiceResult@{isSuccess:true,page:'http:...index.jsp',errormsg:'null'}
    @Override
    public String toString() {
        return "ServiceResult@{isSuccess:" + success + ",page:" + page + ",errormsg:" + errormsg + "}";
    }

    public String getErrormsg() {
        return errormsg;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getPage() {
        return page;
    }
}
