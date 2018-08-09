package com.ten.filter.form;

/**
 * 表单验证功能
 *
 * @date 2018/5/20
 * @auther ten
 */
public interface Verifiable {
    /**
     * Null检测
     *
     * @param val 变量
     * @return boolean
     */
    boolean isNull(String val);

    /**
     * MaxLength检测
     *
     * @param val 变量
     * @param max 最大长度
     * @return boolean
     */
    boolean isTooLong(String val, int max);

    /**
     * MinLength检测
     *
     * @param val 变量
     * @param min 最短长度
     * @return boolean
     */
    boolean isTooShort(String val, int min);

    /**
     * 异同检测
     *
     * @param val1 变量1
     * @param val2 变量2
     * @return boolean
     */
    boolean isDiff(String val1, String val2);
}
