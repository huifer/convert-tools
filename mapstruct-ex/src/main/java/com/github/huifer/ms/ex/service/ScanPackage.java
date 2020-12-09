package com.github.huifer.ms.ex.service;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.huifer.ms.ex.model.ParamAndReturnType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 *
 * @author huifer
 */
public class ScanPackage {

    private static final Logger log = LoggerFactory.getLogger(ScanPackage.class);

    /**
     * key: mapstruct 的类
     * value: mapstruct 实例
     */
    static Map<Class<?>, Object> map = new HashMap<>();

    /**
     * 存储转换类型和对应的method
     * key: source + target class
     * value: 转换方法
     */
    static Map<ParamAndReturnType, Method> mp = new HashMap<>();

    private ScanPackage() {

    }

    public static void loadMappings(List<Class<?>> mappingClass) throws IllegalAccessException {
        // 1. 记录 mapping 对应的实例


        for (Class<?> aClass : mappingClass) {
            Object instance = null;
            for (Field field : aClass.getFields()) {
                if (field.getType().equals(aClass)) {
                    instance = field.get(aClass);
                    break;
                }
            }
            if (instance != null) {

                Map<ParamAndReturnType, Method> paramAndReturnTypeMethodMap = calcClassMethod(aClass);
                mp.putAll(paramAndReturnTypeMethodMap);

                map.put(aClass, instance);
            }

        }
    }

    private static Map<ParamAndReturnType, Method> calcClassMethod(Class<?> clazz) {
        Method[] declaredMethods = clazz.getDeclaredMethods();

        Map<ParamAndReturnType, Method> paramAndReturnTypeMethodMap = new HashMap<>();

        for (Method method : declaredMethods) {

            Class<?> returnType = method.getReturnType();
            int parameterCount = method.getParameterCount();
            Class<?> paramType = null;
            if (parameterCount == 1) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                paramType = parameterTypes[0];
            }
            log.info("return =[{}] ", returnType);
            log.info("paramType =[{}] ", paramType);


            paramAndReturnTypeMethodMap.put(new ParamAndReturnType(paramType, returnType), method);

        }
        return paramAndReturnTypeMethodMap;
    }

}
