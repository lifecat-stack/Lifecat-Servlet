package com.wang.manager;

/**
 * Manager层执行返回结果
 *
 * @date 2018/6/29
 * @auther ten
 */
public class ManagerResult {

    private boolean success;
    private String errorMsg;
    private Object args;

    public ManagerResult(boolean success, String message) {
        this.success = success;
        this.errorMsg = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public Object getArgs() {
        return args;
    }
}
