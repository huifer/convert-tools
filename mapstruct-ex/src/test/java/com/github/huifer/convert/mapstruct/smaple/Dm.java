package com.github.huifer.convert.mapstruct.smaple;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.huifer.convert.mapstruct.model.UserEntity;
import com.github.huifer.convert.mapstruct.model.UserTarget;
import com.github.huifer.ms.ex.model.ParamAndReturnType;

/**
 *
 *
 * @author huifer
 */
public class Dm {


    static Map<Class<?>, Object> map = new HashMap<>();

    static Map<ParamAndReturnType, Method> mp = new HashMap<>();

    public static void main(String[] args) throws Exception {
//        extracted();
        UserEntity userEntity = new UserEntity();

        userEntity.setName("a");

        UserTarget userTarget = UserConvert.INSTANCE.toTarget(userEntity);


        List<Class<?>> mappingClass = new ArrayList<>();
        mappingClass.add(UserConvert.class);

        // 1. 记录 mapping 对应的实例
        labelMapping(mappingClass);


        Method method = mp.get(new ParamAndReturnType(UserEntity.class, userTarget.getClass()));

        Object o = map.get(method.getDeclaringClass());


        Object invoke = method.invoke(o, userEntity);
        System.out.println();
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
            System.out.println("return " + returnType);
            System.out.println("paramType " + paramType);


            paramAndReturnTypeMethodMap.put(new ParamAndReturnType(paramType, returnType), method);

        }
        return paramAndReturnTypeMethodMap;
    }

    private static void labelMapping(List<Class<?>> mappingClass) throws IllegalAccessException {
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

    private static void extracted() throws IllegalAccessException {


//        UserTarget userTarget = UserConvert.INSTANCE.toTarget(userEntity);

        Class<UserConvert> userConvertClass = UserConvert.class;

        Field[] declaredFields = userConvertClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            Object o = declaredField.get(UserConvert.class);
            System.out.println();
        }
    }
}
