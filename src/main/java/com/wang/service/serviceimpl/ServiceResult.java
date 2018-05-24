package com.wang.service.serviceimpl;

import com.wang.bean.MyBuilder;
import com.wang.constant.Page;

/**
 * ServiceResult: 返回ServiceModel执行结果对象
 * <p>
 * 访问范围: 构造器包访问
 * 访问范围: getter全局
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

        //page: 默认指向index界面
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

    //ServiceResult@{isSuccess:true,page:'http:...index.jsp',errormsg:'null'}
    @Override
    public String toString() {
        return "ServiceResult@{isSuccess:" + success + ",page:" + page + ",errormsg:" + errormsg + "}";
    }

    //getter
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
