package com.github.huifer.convert.forspring.start;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.github.huifer.convert.forspring.hold.SpringApplicationHolder;
import com.github.huifer.convert.think.api.CommonConvert;
import com.github.huifer.convert.think.api.ConvertRegister;
import com.github.huifer.convert.think.impl.DefaultConvertRegister;
import com.github.huifer.convert.think.scan.ScanUtils;

import org.springframework.context.ApplicationContext;

/**
 *
 *
 * @author huifer
 */
//@Service("forSpringCommonRunner")
public class ForSpringCommonRunner {

    public static final Class<?> COMMON_CONVERT_CLASS = CommonConvert.class;

    private final List<Class<?>> inSpringContext = new ArrayList<>(10);

    private final String[] packages;

    ConvertRegister register = new DefaultConvertRegister();


    public ForSpringCommonRunner(String[] packages) {
        this.packages = packages;
        start(this.packages);
    }

    public void start(String[] scanPackages) {

        // 1. 从容器中获取 CommonConvert
        ApplicationContext context = SpringApplicationHolder.getApplicationContext();
        Map<String, CommonConvert> commonConvertMap = context.getBeansOfType(CommonConvert.class);

        commonConvertMap.forEach(
                (name, instance) -> {
                    Class<? extends CommonConvert> aClass = instance.getClass();
                    inSpringContext.add(aClass);
                    register.register(instance);
                }
        );


        Set<Class<?>> scan = ScanUtils.scan(scanPackages);


        for (Class<?> aClass : scan) {
            if (!inSpringContext.contains(aClass)) {

                try {
                    register.register((Class<? extends CommonConvert>) aClass);
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

}
