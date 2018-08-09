package com.ten.filter.form.impl;

import com.ten.filter.form.Verifiable;

/**
 * 表单验证功能实现
 *
 * @date 2018/5/20
 * @auther ten
 */
class BaseVerification implements Verifiable {
    /**
     * Null检测
     *
     * @param val 变量
     * @return boolean
     */
    @Override
    public boolean isNull(String val) {
        return val.length() == 0;
    }

    /**
     * MaxLength检测
     *
     * @param val 变量
     * @param max 最大长度
     * @return boolean
     */
    @Override
    public boolean isTooLong(String val, int max) {
        return val.length() > max;
    }

    /**
     * MinLength检测
     *
     * @param val 变量
     * @param min 最短长度
     * @return boolean
     */
    @Override
    public boolean isTooShort(String val, int min) {
        return val.length() < min;
    }

    /**
     * 异同检测
     *
     * @param val1 变量1
     * @param val2 变量2
     * @return boolean
     */
    @Override
    public boolean isDiff(String val1, String val2) {
        return !val1.equals(val2);
    }
}
