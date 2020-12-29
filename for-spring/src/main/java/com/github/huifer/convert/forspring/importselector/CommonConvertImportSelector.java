package com.github.huifer.convert.forspring.importselector;

import java.util.Map;

import com.github.huifer.convert.forspring.annotation.EnableCommonConvert;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 *
 *
 * @author huifer
 */
public class CommonConvertImportSelector implements ImportSelector {

    public static String[] PACK = null;

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {

        Map<String, Object> annotationAttributes = annotationMetadata
                .getAnnotationAttributes(EnableCommonConvert.class.getName());
        String[] scanPackages = (String[]) annotationAttributes.get("scanPackages");
        PACK = scanPackages;
        return new String[0];
    }
}
