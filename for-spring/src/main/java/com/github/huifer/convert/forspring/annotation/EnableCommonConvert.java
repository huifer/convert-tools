package com.github.huifer.convert.forspring.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.github.huifer.convert.forspring.beans.Beans;
import com.github.huifer.convert.forspring.importselector.CommonConvertImportSelector;

import org.springframework.context.annotation.Import;

/**
 *
 *
 * @author huifer
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({Beans.class, CommonConvertImportSelector.class})
public @interface EnableCommonConvert {
    String[] scanPackages() default {};

}
