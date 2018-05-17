package com.wang.service;

import com.wang.util.HOST;
import com.wang.util.MyBuilder;

/**
 * ModelResult: 返回ServiceModel执行结果对象
 * <p>
 * 访问范围: 构造器包访问
 * 访问范围: getter全局
 *
 * @auther ten
 */
public class ModelResult {

    private final boolean error;
    private final String page;
    private final String errormsg;

    private ModelResult(Builder builder) {
        this.error = builder.error;
        this.page = builder.page;
        this.errormsg = builder.errormsg;
    }

    /**
     * Builder: ModelResult构建器
     *
     * @auther ten
     */
    protected static class Builder implements MyBuilder<ModelResult> {

        private final boolean error;

        //page: 默认指向index界面
        private String errormsg = "null";
        private String page = HOST.PAGE_INDEX;

        protected Builder(boolean error) {
            this.error = error;
        }

        protected ModelResult.Builder errormsg(String errormsg) {
            this.errormsg = errormsg;
            return this;
        }

        protected ModelResult.Builder page(String page) {
            this.page = page;
            return this;
        }

        @Override
        public ModelResult build() {
            return new ModelResult(this);
        }
    }

    //ModelResult@{isError:true,page:'http:...index.jsp',errormsg:'null'}
    @Override
    public String toString() {
        return "ModelResult@{isError:" + error + ",page:" + page + ",errormsg:" + errormsg + "}";
    }

    //getter
    public String getErrormsg() {
        return errormsg;
    }

    public Boolean isError() {
        return error;
    }

    public String getPage() {
        return page;
    }
}
