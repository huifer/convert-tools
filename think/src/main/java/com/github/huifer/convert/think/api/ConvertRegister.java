package com.github.huifer.convert.think.api;

/**
 * convert 注册接口
 *
 * @author huifer
 */
public interface ConvertRegister {
    /**
     * 注册 convert 接口
     * @param convert convert 接口
     */
    void register(Convert<?, ?> convert);

    /**
     * 注册 convert 接口
     * @param convert convert 类
     */
    void register(Class<? extends Convert> convert) throws IllegalAccessException, InstantiationException;
}
