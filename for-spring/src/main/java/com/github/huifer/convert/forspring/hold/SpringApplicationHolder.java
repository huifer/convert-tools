package com.github.huifer.convert.forspring.hold;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 *
 *
 * @author huifer
 */
@Component
public class SpringApplicationHolder implements ApplicationContextAware {
    private static ApplicationContext CONTEXT;

    public static ApplicationContext getApplicationContext() {
        return CONTEXT;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        CONTEXT = applicationContext;
    }
}
