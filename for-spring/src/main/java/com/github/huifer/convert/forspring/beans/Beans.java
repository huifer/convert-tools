package com.github.huifer.convert.forspring.beans;

import com.github.huifer.convert.forspring.importselector.CommonConvertImportSelector;
import com.github.huifer.convert.forspring.start.ForSpringCommonRunner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 *
 *
 * @author huifer
 */
@Component
@ComponentScan("com.github.huifer.convert.forspring")
public class Beans {
    @Bean
    public ForSpringCommonRunner forSpringCommonRunner() {
        return new ForSpringCommonRunner(CommonConvertImportSelector.PACK);
    }
}
