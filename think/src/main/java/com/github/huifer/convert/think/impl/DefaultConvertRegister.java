package com.github.huifer.convert.think.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.github.huifer.convert.think.api.CommonConvert;
import com.github.huifer.convert.think.api.ConvertRegister;
import com.github.huifer.convert.think.model.ConvertSourceAndTarget;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 *
 * @author huifer
 */
public class DefaultConvertRegister implements ConvertRegister {


    private static final Logger log = LoggerFactory.getLogger(DefaultConvertRegister.class);

    static Map<ConvertSourceAndTarget, CommonConvert> convertMap
            = new ConcurrentHashMap<>(256);


    public static CommonConvert getConvertMap(ConvertSourceAndTarget param) {
        if (log.isInfoEnabled()) {
            log.info("getConvertMap,param = {}", param);
        }
        if (param == null) {
            return null;
        }
        else if (convertMap.containsKey(param)) {
            return convertMap.get(param);
        }
        return null;
    }

    @Override
    public void register(CommonConvert commonConvert) {

        if (commonConvert == null) {
            log.warn("当前传入的convert对象为空");
            return;
        }


        Class<? extends CommonConvert> convertClass = commonConvert.getClass();

        handler(commonConvert, convertClass);

    }

    private void handler(CommonConvert commonConvert, Class<? extends CommonConvert> convertClass) {
        Type[] genericInterfaces = convertClass.getGenericInterfaces();

        for (Type genericInterface : genericInterfaces) {
            ParameterizedType pType = (ParameterizedType) genericInterface;
            boolean equals = pType.getRawType().equals(CommonConvert.class);
            if (equals) {
                Type[] actualTypeArguments = pType.getActualTypeArguments();

                if (actualTypeArguments.length == 2) {
                    Type a1 = actualTypeArguments[0];
                    Type a2 = actualTypeArguments[1];

                    try {

                        Class<?> sourceClass = Class.forName(a1.getTypeName());
                        Class<?> targetClass = Class.forName(a2.getTypeName());

                        ConvertSourceAndTarget convertSourceAndTarget =
                                new ConvertSourceAndTarget(sourceClass,
                                        targetClass);
                        // 如果类型相同 覆盖
                        convertMap.put(convertSourceAndTarget, commonConvert);
                    }
                    catch (Exception e) {
                        log.error("a1=[{}]", a1);
                        log.error("a2=[{}]", a2);
                        log.error("从泛型中转换成class异常", e);
                    }
                }
            }
        }
    }


    @Override
    public void register(Class<? extends CommonConvert> convert) throws IllegalAccessException, InstantiationException {
        if (convert == null) {
            log.warn("当前传入的convert对象为空");
            return;
        }

        CommonConvert cv = convert.newInstance();

        if (cv != null) {
            handler(cv, convert);
        }

    }

}
