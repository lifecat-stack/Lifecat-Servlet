package com.wang.bean;

/**
 * @name BeanBuilder
 * @description Bean类构建器
 * @auther ten
 */
public interface BeanBuilder<T> {
    //泛型
    public T build();
}
