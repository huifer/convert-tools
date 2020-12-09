package com.github.huifer.ms.ex.service;

import java.lang.reflect.Method;

import com.github.huifer.ms.ex.model.ParamAndReturnType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 *
 * @author huifer
 */

public class MapstructFacade {
    private static final Logger log = LoggerFactory.getLogger(MapstructFacade.class);

    private MapstructFacade() {
    }

    public static <T> T convert(Object source, Class<T> target) {
        Method convertMethod = ScanPackage.mp.get(new ParamAndReturnType(source.getClass(), target));
        Object o = ScanPackage.map.get(convertMethod.getDeclaringClass());

        try {
            return (T) convertMethod.invoke(o, source);
        }

        catch (Exception e) {
            log.error("转换失败", e);
        }
        return null;

    }
}
