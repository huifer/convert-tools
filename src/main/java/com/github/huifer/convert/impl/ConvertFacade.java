package com.github.huifer.convert.impl;

import com.github.huifer.convert.api.Convert;
import com.github.huifer.convert.model.ConvertSourceAndTarget;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 *
 * @author huifer
 */
public class ConvertFacade {
    private static final Logger log = LoggerFactory.getLogger(ConvertFacade.class);

    private ConvertFacade() {

    }

    /**
     * 转换
     * @param source 源对象
     * @param target 目标对象类型
     * @param <T> 目标对象泛型
     */
    public static <T> T convert(Object source, Class<T> target) {
        if (log.isInfoEnabled()) {
            log.info("convert,source = {}, target = {}", source, target);
        }

        if (source == null || target == null) {
            throw new IllegalArgumentException("参数异常请重新检查");
        }


        ConvertSourceAndTarget convertSourceAndTarget = new ConvertSourceAndTarget(source.getClass(), target);

        Convert convert = DefaultConvertRegister.getConvertMap(convertSourceAndTarget);
        if (convert != null) {

            return (T) convert.convert(source);
        }
        return null;
    }
}
