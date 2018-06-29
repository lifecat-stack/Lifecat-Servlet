package com.wang.manager;

/**
 * Manager层执行返回结果
 *
 * @date 2018/6/29
 * @auther ten
 */
public class ManagerResult {
    /**
     * 1.执行成功标志
     * 2.错误信息
     * 3.参数对象
     */
    private boolean success;
    private String errorMsg;
    private Object args;

    /**
     * false:
     *
     * @param success false
     * @param message 错误信息
     */
    public ManagerResult(boolean success, String message) {
        this.success = success;
        this.errorMsg = message;
    }

    /**
     * true:
     *
     * @param success true
     * @param args    返回对象
     */
    public ManagerResult(boolean success, Object args) {
        this.success = success;
        this.args = args;
    }

    /**
     * getter
     */
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
