package com.wang.model;

import java.util.logging.Logger;

/**
 * @name ErrorMsg
 * @description 模型处理时产生的错误
 * @auther
 */
public class ErrorMsg {
    private static Logger logger = Logger.getLogger("ErrorMsg");


    private boolean isError;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isError() {
        return isError;
    }

    public void setIsError(boolean error) {
        isError = error;
    }

    /* model执行发生错误 */
    public void setError(String msg) {
        logger.warning(msg);
        this.setIsError(true);
        this.setMessage(msg);
    }

    /* model执行正确 */
    public void setTrue() {
        logger.info("model执行成功");
        this.setIsError(false);
        this.setMessage(null);
    }

    public void printError(String err) {
        logger.warning(err + "方法错误");
    }
}
