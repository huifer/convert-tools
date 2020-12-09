package com.github.huifer.convert.api;

/**
 * 对象转换接口
 *
 * @author huifer
 */
public interface Convert<S, T> {
    /**
     * 转换
     * @param source 原始对象
     * @return 转换结果对象
     */
    T convert(S source);
}
