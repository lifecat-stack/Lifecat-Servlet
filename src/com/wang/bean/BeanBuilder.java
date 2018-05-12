package com.wang.bean;

/**
 * Bean构建器:四个参数及以上时使用
 *
 * @auther ten
 */
public interface BeanBuilder<T> {
    //泛型
    public T build();
}
