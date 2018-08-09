package com.ten.manager;

/**
 * Manager
 * <p>
 * 使用外观模式对DAO层进行包装，执行DAO抽象逻辑操作
 * <p>
 * 对service层的下沉处理: 抽象业务逻辑->抽象DAO逻辑
 * DAO逻辑层, 接收DO对象, 调用DAO层对DO执行具体操作
 *
 * @auther ten
 */
public interface Manager {

}
