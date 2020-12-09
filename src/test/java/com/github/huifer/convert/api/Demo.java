package com.github.huifer.convert.api;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLOutput;

/**
 *
 *
 * @author huifer
 */
public class Demo {


    public static class AConvert implements Convert<Integer, String> {
        @Override
        public String convert(Integer source) {
            return String.valueOf(source);
        }
    }

    public static void main(String[] args) {
        Class<AConvert> aConvertClass = AConvert.class;

        Type[] genericInterfaces = aConvertClass.getGenericInterfaces();

        for (Type genericInterface : genericInterfaces) {
            ParameterizedType pType = (ParameterizedType) genericInterface;
            boolean equals = pType.getRawType().equals(Convert.class);
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
