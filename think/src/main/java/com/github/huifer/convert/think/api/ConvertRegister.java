package com.github.huifer.convert.think.api;

/**
 * convert 注册接口
 *
 * @author huifer
 */
public interface ConvertRegister {
    /**
     * 注册 convert 接口
     * @param commonConvert convert 接口
     */
    void register(CommonConvert<?, ?> commonConvert);


    /**
     * 注册 convert 接口
     * @param convert convert 类
     */
    void register(Class<? extends CommonConvert> convert) throws IllegalAccessException, InstantiationException;
}
