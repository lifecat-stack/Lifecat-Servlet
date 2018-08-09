package com.ten.bean;

/**
 * MyBuilder: 构建器,四个参数及以上时使用
 *
 * @auther ten
 */
public interface MyBuilder<T> {
    T build();
}
