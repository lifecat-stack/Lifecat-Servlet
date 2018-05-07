package com.wang.form;

import java.util.logging.Logger;

/**
 * @name FormResult
 * @description 表单验证返回结果集
 * @auther ten
 */
public class FormResult {
    private Boolean isError;
    private String errorMsg;
    private static Logger logger=Logger.getLogger("FormResult");

    public Boolean getIsError() {
        return isError;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setIsError(Boolean isError) {
        this.isError = isError;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    /* 设置错误result,并打印错误信息*/
    public void setError(String msg) {
        this.setIsError(true);
        this.setErrorMsg(msg);
        logger.warning(msg);
    }

    /* 设置正确result,并打印正确信息 */
    public void setTrue() {
        this.setIsError(false);
        this.setErrorMsg(null);
        logger.info("Form验证通过");
    }
}
