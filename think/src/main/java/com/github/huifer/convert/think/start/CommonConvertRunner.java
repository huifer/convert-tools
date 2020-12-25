package com.github.huifer.convert.think.start;

import java.util.Set;

import com.github.huifer.convert.think.api.CommonConvert;
import com.github.huifer.convert.think.api.ConvertRegister;
import com.github.huifer.convert.think.impl.DefaultConvertRegister;
import com.github.huifer.convert.think.scan.ScanUtils;

/**
 *
 *
 * @author huifer
 */
public class CommonConvertRunner {
    public static final Class COMMON_CONVERT_CLASS = CommonConvert.class;

    static ConvertRegister convertRegister = new DefaultConvertRegister();

    public static void start(String[] paths) {



        Set<Class<?>> scan = ScanUtils.scan(paths);

        for (Class<?> aClass : scan) {

            Class<?>[] interfaces = aClass.getInterfaces();

            if (isCommonConvert(interfaces)) {

                try {
                    convertRegister.register((Class<? extends CommonConvert>) aClass);
                }
                catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    private static boolean isCommonConvert(Class<?>[] interfaces) {
        for (Class<?> anInterface : interfaces) {
            if (anInterface.equals(COMMON_CONVERT_CLASS)) {
                return true;
            }
        }
        return false;
    }
}
