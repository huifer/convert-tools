package com.github.huifer.convert.think.api;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 *
 *
 * @author huifer
 */
public class Demo {


    public static class ACommonConvert implements CommonConvert<Integer, String> {
        @Override
        public String convert(Integer source) {
            return String.valueOf(source);
        }
    }

    public static void main(String[] args) {
        Class<ACommonConvert> aConvertClass = ACommonConvert.class;

        Type[] genericInterfaces = aConvertClass.getGenericInterfaces();

        for (Type genericInterface : genericInterfaces) {
            ParameterizedType pType = (ParameterizedType) genericInterface;
            boolean equals = pType.getRawType().equals(CommonConvert.class);
            if (equals) {
                Type[] actualTypeArguments = pType.getActualTypeArguments();

                if (actualTypeArguments.length==2) {
                    Type a1 = actualTypeArguments[0];
                    Type a2 = actualTypeArguments[1];

                }
            }
        }
    }
}
